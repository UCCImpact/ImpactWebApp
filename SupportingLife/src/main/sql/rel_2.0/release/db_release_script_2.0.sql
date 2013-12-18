-----------------------------------------------------------------------------------------------------------------
-- SUPPORTING LIFE RELEASE 2.0 RELEASE SCRIPT
-----------------------------------------------------------------------------------------------------------------

-----------------------------------------------------------------------------------------------------------------
-- CREATE DATABASE supportinglifedb
-----------------------------------------------------------------------------------------------------------------
CREATE DATABASE IF NOT EXISTS supportinglifedb;

-----------------------------------------------------------------------------------------------------------------
-- CREATE CCM-RELATED TABLE: sl_ccm_patient_details
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
CREATE TABLE IF NOT EXISTS sl_ccm_patient_details (
    												patient_id INTEGER(18) NOT NULL AUTO_INCREMENT,
    												user_id VARCHAR(8),
    												first_name VARCHAR(50),
    												surname VARCHAR(50),
    												date_of_birth DATETIME,
    												gender TINYINT(1),
    												caregiver_name VARCHAR(100),
    												relationship VARCHAR(7),
    												other_relationship VARCHAR(50),
    												physical_address VARCHAR(250),
    												village_ta VARCHAR(50),
    												created_dt DATETIME,
    												updated_dt DATETIME,
    												added_by VARCHAR(8),
    												PRIMARY KEY (patient_id)
												  );

-----------------------------------------------------------------------------------------------------------------
-- CLEAN CCM-RELATED TABLE: sl_ccm_patient_details
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
TRUNCATE TABLE sl_ccm_patient_details;
