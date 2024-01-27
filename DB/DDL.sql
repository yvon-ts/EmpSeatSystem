CREATE TABLE `office` (
  `office_id` int NOT NULL,
  `office_name` varchar(32) NOT NULL,
  PRIMARY KEY (`office_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `department` (
  `dept_id` int NOT NULL,
  `dept_name` varchar(32) NOT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `seating_chart` (
  `floor_seat_seq` int NOT NULL AUTO_INCREMENT,
  `floor_no` tinyint NOT NULL,
  `seat_no` int NOT NULL,
  `office_id` int NOT NULL,
  `state` tinyint NOT NULL DEFAULT '0',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`floor_seat_seq`),
  KEY `office_id` (`office_id`),
  CONSTRAINT `seating_chart_ibfk_1` FOREIGN KEY (`office_id`) REFERENCES `office` (`office_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `employee` (
  `emp_id` int NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(32) NOT NULL,
  `email` varchar(32) NOT NULL,
  `dept_id` int NOT NULL,
  `floor_seat_seq` int DEFAULT NULL,
  `state` tinyint NOT NULL DEFAULT '0',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`emp_id`),
  KEY `dept_id` (`dept_id`),
  KEY `floor_seat_seq` (`floor_seat_seq`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `department` (`dept_id`),
  CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`floor_seat_seq`) REFERENCES `seating_chart` (`floor_seat_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=12351 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
alter table employee auto_increment = 12345;
-- ---------------------------------------------
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_emp_seating_chart` AS select `s`.`floor_seat_seq` AS `floor_seat_seq`,`s`.`office_id` AS `office_id`,`s`.`floor_no` AS `floor_no`,`s`.`seat_no` AS `seat_no`,`s`.`state` AS `state`,`e`.`emp_id` AS `emp_id`,`e`.`emp_name` AS `emp_name`,`e`.`dept_id` AS `dept_id`,`d`.`dept_name` AS `dept_name` from ((`seating_chart` `s` left join `employee` `e` on((`s`.`floor_seat_seq` = `e`.`floor_seat_seq`))) left join `department` `d` on((`e`.`dept_id` = `d`.`dept_id`)));
-- ---------------------------------------------
DELIMITER $$
CREATE PROCEDURE get_office_floor_seat(IN p_office_id INT, IN p_floor_no INT)
BEGIN
    IF p_office_id IS NULL THEN
        select * from office;
        
    ELSEIF p_floor_no IS NULL THEN
        select office_id, floor_no, state, count(1) as count from seating_chart
		where office_id = p_office_id
		group by office_id, floor_no, state;
        
    ELSE
        select * from v_emp_seating_chart
		where office_id = p_office_id and floor_no = p_floor_no;
    END IF;
END $$
-- ---------------------------------------------
CREATE PROCEDURE get_dept_emp(IN p_dept_id INT)
BEGIN
    IF p_dept_id IS NULL THEN
        select * from department;
	ELSE
		select d.dept_id, dept_name, emp_id, emp_name, floor_seat_seq
        from department d left join employee e
		on d.dept_id = e.dept_id
		where d.dept_id = p_dept_id;
    END IF;
END $$
-- ---------------------------------------------
CREATE PROCEDURE update_emp_seat(IN flag_change INT, IN p_floor_seat_seq INT, IN p_emp_id INT)
BEGIN
	DECLARE tmp_floor_seat_seq INT;
	DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
    END;
	START TRANSACTION;

    IF flag_change = 1 THEN -- make old seat empty
		select floor_seat_seq into tmp_floor_seat_seq from v_emp_seating_chart where emp_id = p_emp_id;
    
		update seating_chart set state = 0
		where floor_seat_seq = tmp_floor_seat_seq;
    END IF;
    
		update seating_chart set state = 1
		where floor_seat_seq = p_floor_seat_seq;
		
        update employee set floor_seat_seq = p_floor_seat_seq
        where emp_id = p_emp_id;
    
    COMMIT;

END $$
DELIMITER ;
