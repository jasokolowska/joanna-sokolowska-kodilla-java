CREATE TABLE STATS (
                       STAT_ID INT(11) AUTO_INCREMENT PRIMARY KEY,
                       STAT_DATE DATETIME NOT NULL,
                       STAT VARCHAR(20) NOT NULL,
                       VALUE INT(11) NOT NULL);

CREATE VIEW BESTSELLERS_COUNT AS
SELECT count(*) FROM BOOKS
WHERE BESTSELLER=1;

USE KODILLA_COURSE;
DELIMITER $$

CREATE EVENT UPDATE_BESTSELLERS
    ON SCHEDULE EVERY 1 MINUTE
    DO
    BEGIN
        INSERT INTO STATS (STAT_DATE, STAT, VALUE)
        VALUES (curdate(), "BESTSELLERS", KODILLA_COURSE.bestsellers_count.`count(*)`);
        CALL UpdateBestsellers();
    end$$

delimiter ;

select * from STATS;

drop event UPDATE_BESTSELLERS;