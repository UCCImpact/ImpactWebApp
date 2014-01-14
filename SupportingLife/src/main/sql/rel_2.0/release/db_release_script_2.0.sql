-----------------------------------------------------------------------------------------------------------------
-- SUPPORTING LIFE RELEASE 2.0 RELEASE SCRIPT
-----------------------------------------------------------------------------------------------------------------

-----------------------------------------------------------------------------------------------------------------
-- CREATE DATABASE supportinglifedb
-----------------------------------------------------------------------------------------------------------------
CREATE DATABASE IF NOT EXISTS supportinglifedb;

-----------------------------------------------------------------------------------------------------------------
-- CREATE CCM-RELATED TABLE: sl_user
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
CREATE TABLE IF NOT EXISTS sl_user (
    								user_id VARCHAR(8) NOT NULL,
    								password VARCHAR(250),
    								ccm_user TINYINT(1),
    								imci_user TINYINT(1),
    								first_name VARCHAR(50),
    								surname VARCHAR(50),
    								role VARCHAR(10),
    								created_dt DATETIME,
    								updated_dt DATETIME,
    								PRIMARY KEY (user_id)
									);

-----------------------------------------------------------------------------------------------------------------
-- CLEAN CCM-RELATED TABLE: sl_user
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
TRUNCATE TABLE sl_user;

-----------------------------------------------------------------------------------------------------------------
-- CREATE CCM-RELATED TABLE: sl_ccm_patient
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
CREATE TABLE IF NOT EXISTS sl_ccm_patient(
										 	patient_id INTEGER(18) NOT NULL AUTO_INCREMENT,
    										user_id VARCHAR(8),
    										first_name VARCHAR(50),
    										surname VARCHAR(50),
    										date_of_birth DATETIME,
    										gender VARCHAR(6),
    										caregiver_name VARCHAR(100),
    										relationship VARCHAR(7),
    										other_relationship VARCHAR(50),
    										physical_address VARCHAR(250),
    										village_ta VARCHAR(50),
    										created_dt DATETIME,
    										updated_dt DATETIME,
    										PRIMARY KEY (patient_id),
                       						FOREIGN KEY (user_id) REFERENCES sl_user(user_id)
										  );

-----------------------------------------------------------------------------------------------------------------
-- CLEAN CCM-RELATED TABLE: sl_ccm_patient
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
TRUNCATE TABLE sl_ccm_patient;
