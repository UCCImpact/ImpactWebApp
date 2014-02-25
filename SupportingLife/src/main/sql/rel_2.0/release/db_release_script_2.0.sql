-----------------------------------------------------------------------------------------------------------------
-- SUPPORTING LIFE RELEASE 2.0 RELEASE SCRIPT
-----------------------------------------------------------------------------------------------------------------

-----------------------------------------------------------------------------------------------------------------
-- CREATE DATABASE supportinglifedb
-----------------------------------------------------------------------------------------------------------------
CREATE DATABASE IF NOT EXISTS supportinglifedb;


-------------------------------------*********************************-------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- CREATE CCM-RELATED TABLE: sl_user
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
CREATE TABLE IF NOT EXISTS sl_user (
    								user_id 		VARCHAR(8) NOT NULL,
    								password 		VARCHAR(250),
    								ccm_user 		TINYINT(1),
    								imci_user 		TINYINT(1),
    								first_name 		VARCHAR(50),
    								surname 		VARCHAR(50),
    								role 			VARCHAR(10),
    								created_dt 		TIMESTAMP,
    								updated_dt 		TIMESTAMP,
    								PRIMARY KEY (user_id)
									);

-----------------------------------------------------------------------------------------------------------------
-- CLEAN CCM-RELATED TABLE: sl_user
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
TRUNCATE TABLE sl_user;
-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------


-------------------------------------*********************************-------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- CREATE CCM-RELATED TABLE: sl_ccm_patient
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
CREATE TABLE IF NOT EXISTS sl_ccm_patient(
										 	patient_id 				INTEGER(18) NOT NULL AUTO_INCREMENT,
										 	national_id 			VARCHAR(8),
										 	national_health_id 		VARCHAR(8),
    										child_first_name 		VARCHAR(50),
    										child_surname 			VARCHAR(50),
    										date_of_birth 			DATE,
    										gender 					VARCHAR(6),
    										caregiver_name 			VARCHAR(100),
    										relationship 			VARCHAR(50),
    										physical_address 		VARCHAR(250),
    										village_ta 				VARCHAR(50),
    										created_dt 				TIMESTAMP,
    										updated_dt 				TIMESTAMP,
    										INDEX national_id_index (national_id),
    										INDEX national_health_id_index (national_health_id),
    										PRIMARY KEY (patient_id)
										  );

-----------------------------------------------------------------------------------------------------------------
-- CLEAN CCM-RELATED TABLE: sl_ccm_patient
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
TRUNCATE TABLE sl_ccm_patient;
-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------


-------------------------------------*********************************-------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- CREATE CCM-RELATED TABLE: sl_ccm_patient_visit
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
CREATE TABLE IF NOT EXISTS sl_ccm_patient_visit (
    												visit_id 				INTEGER(18) NOT NULL AUTO_INCREMENT,
    												device_generated_id		VARCHAR(250),
    												patient_id 				INTEGER(18) NOT NULL,
    												visit_dt 				DATE,
    												user_id 				VARCHAR(8),
				    								PRIMARY KEY (visit_id),
				    								FOREIGN KEY (patient_id) REFERENCES sl_ccm_patient(patient_id),
                       								FOREIGN KEY (user_id) REFERENCES sl_user(user_id)
												);

												
-----------------------------------------------------------------------------------------------------------------
-- CLEAN CCM-RELATED TABLE: sl_ccm_patient_visit
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
TRUNCATE TABLE sl_ccm_patient_visit;
-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------

-------------------------------------*********************************-------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- CREATE CCM-RELATED TABLE: sl_ccm_classification
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
CREATE TABLE IF NOT EXISTS sl_ccm_classification (
    												classification_id 			INTEGER(18) NOT NULL AUTO_INCREMENT,
    												classification_key			VARCHAR(250),
    												classification_name			VARCHAR(1000),
    												INDEX classification_index (classification_key),
				    								PRIMARY KEY (classification_id)
												 );

-----------------------------------------------------------------------------------------------------------------
-- CLEAN CCM-RELATED TABLE: sl_ccm_classification
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
TRUNCATE TABLE sl_ccm_classification;
-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------

-------------------------------------*********************************-------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- CREATE CCM-RELATED TABLE: sl_ccm_patient_classification
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
CREATE TABLE IF NOT EXISTS sl_ccm_patient_classification (
													id 					INTEGER(18) NOT NULL AUTO_INCREMENT,
    												visit_id 			INTEGER(18) NOT NULL,
    												patient_id 			INTEGER(18) NOT NULL,
    												classification_id 	INTEGER(18) NOT NULL,
    												INDEX patient_classification_index (patient_id, classification_id),
    												PRIMARY KEY (id),
				    								FOREIGN KEY (visit_id) REFERENCES sl_ccm_patient_visit(visit_id),
				    								FOREIGN KEY (patient_id) REFERENCES sl_ccm_patient(patient_id),
				    								FOREIGN KEY (classification_id) REFERENCES sl_ccm_classification(classification_id)
												);

-----------------------------------------------------------------------------------------------------------------
-- CLEAN CCM-RELATED TABLE: sl_ccm_patient_classification
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
TRUNCATE TABLE sl_ccm_patient_classification;
-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------


-------------------------------------*********************************-------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- CREATE CCM-RELATED TABLE: sl_ccm_treatment
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
CREATE TABLE IF NOT EXISTS sl_ccm_treatment (
    											treatment_id 		INTEGER(18) NOT NULL AUTO_INCREMENT,
    											treatment_key		VARCHAR(250),
    											description 		VARCHAR(1000),
    											INDEX treatment_index (treatment_key),
				    							PRIMARY KEY (treatment_id)
											 );

-----------------------------------------------------------------------------------------------------------------
-- CLEAN CCM-RELATED TABLE: sl_ccm_treatment
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
TRUNCATE TABLE sl_ccm_treatment;
-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------


-------------------------------------*********************************-------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- CREATE CCM-RELATED TABLE: sl_ccm_patient_treatment
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
CREATE TABLE IF NOT EXISTS sl_ccm_patient_treatment (
													id 				INTEGER(18) NOT NULL AUTO_INCREMENT,
    												visit_id 		INTEGER(18) NOT NULL,
    												patient_id 		INTEGER(18) NOT NULL,
    												treatment_id 	INTEGER(18) NOT NULL,
    												INDEX patient_treatment_index (patient_id, treatment_id),
    												PRIMARY KEY (id),
				    								FOREIGN KEY (visit_id) REFERENCES sl_ccm_patient_visit(visit_id),
				    								FOREIGN KEY (patient_id) REFERENCES sl_ccm_patient(patient_id),
				    								FOREIGN KEY (treatment_id) REFERENCES sl_ccm_treatment(treatment_id)
												);

-----------------------------------------------------------------------------------------------------------------
-- CLEAN CCM-RELATED TABLE: sl_ccm_patient_treatment
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
TRUNCATE TABLE sl_ccm_patient_treatment;
-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------


-------------------------------------*********************************-------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- CREATE CCM-RELATED TABLE: sl_ccm_look_symptoms
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
CREATE TABLE IF NOT EXISTS sl_ccm_look_symptoms (
													id 					INTEGER(18) NOT NULL AUTO_INCREMENT,
    												visit_id 			INTEGER(18) NOT NULL,
    												patient_id 			INTEGER(18) NOT NULL,
    												chest_indrawing 	TINYINT(1),
    												breaths_per_minute 	INTEGER(4),
    												sleepy_unconscious 	TINYINT(1),
    												palmar_pallor	 	TINYINT(1),
    												muac_tape_colour 	VARCHAR(30),
    												swelling_both_feet 	TINYINT(1),
    												PRIMARY KEY (id),
				    								FOREIGN KEY (visit_id) REFERENCES sl_ccm_patient_visit(visit_id),
				    								FOREIGN KEY (patient_id) REFERENCES sl_ccm_patient(patient_id)
												);

-----------------------------------------------------------------------------------------------------------------
-- CLEAN CCM-RELATED TABLE: sl_ccm_look_symptoms
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
TRUNCATE TABLE sl_ccm_look_symptoms;
-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------

-------------------------------------*********************************-------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- CREATE CCM-RELATED TABLE: sl_ccm_ask_look_symptoms
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
CREATE TABLE IF NOT EXISTS sl_ccm_ask_look_symptoms (
													id 										INTEGER(18) NOT NULL AUTO_INCREMENT,
    												visit_id 								INTEGER(18) NOT NULL,
    												patient_id 								INTEGER(18) NOT NULL,
    												problem						 			VARCHAR(1000),
    												cough						 			TINYINT(1),
    												cough_duration				 			INTEGER(4),
    												diarrhoea								TINYINT(1),
    												diarrhoea_duration			 			INTEGER(4),
    												blood_in_stool							TINYINT(1),
    												fever									TINYINT(1),
    												fever_duration			 				INTEGER(4),
    												convulsions								TINYINT(1),
    												difficulty_drink_feed					TINYINT(1),
    												not_able_drink_feed						TINYINT(1),
    												vomiting								TINYINT(1),
    												vomits_everything						TINYINT(1),
    												red_eye									TINYINT(1),
    												red_eye_duration 						INTEGER(4),
    												difficulty_in_seeing					TINYINT(1),
    												difficulty_in_seeing_duration 			INTEGER(4),
    												other_problems					 			VARCHAR(1000),
    												PRIMARY KEY (id),
				    								FOREIGN KEY (visit_id) REFERENCES sl_ccm_patient_visit(visit_id),
				    								FOREIGN KEY (patient_id) REFERENCES sl_ccm_patient(patient_id)
													);

-----------------------------------------------------------------------------------------------------------------
-- CLEAN CCM-RELATED TABLE: sl_ccm_ask_look_symptoms
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
TRUNCATE TABLE sl_ccm_ask_look_symptoms;
-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------
	
										   