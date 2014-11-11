-----------------------------------------------------------------------------------------------------------------
-- SUPPORTING LIFE RELEASE 5.0 RELEASE SCRIPT
-----------------------------------------------------------------------------------------------------------------

-----------------------------------------------------------------------------------------------------------------
-- CREATE DATABASE supportinglifedb
-----------------------------------------------------------------------------------------------------------------
CREATE DATABASE IF NOT EXISTS supportinglifedb;


-------------------------------------*********************************-------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- CREATE CCM-RELATED TABLE: sl_user
-- (note: password column is case sensitive for additional security)
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
CREATE TABLE IF NOT EXISTS sl_user (
    								user_id 		VARCHAR(8) NOT NULL,
    								password 		VARCHAR(250) COLLATE latin1_general_cs,
    								ccm_user 		TINYINT(1),
    								imci_user 		TINYINT(1),
    								first_name 		VARCHAR(50),
    								surname 		VARCHAR(50),
    								role 			VARCHAR(10),
    								created_dt 		TIMESTAMP,
    								updated_dt 		TIMESTAMP,
    								registered_dt 	TIMESTAMP,
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
    										date_of_birth 			TIMESTAMP NULL,
    										age_months				INTEGER(18),
    										gender 					VARCHAR(6),
    										caregiver_name 			VARCHAR(100),
    										relationship 			VARCHAR(50),
    										physical_address 		VARCHAR(250),
    										village_ta 				VARCHAR(50),
    										created_dt 				TIMESTAMP,
    										updated_dt 				TIMESTAMP,
    										PRIMARY KEY (patient_id),
    										INDEX national_id_index (national_id),
    										INDEX national_health_id_index (national_health_id)
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
    												visit_dt 				TIMESTAMP,
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
    											treatment_id 			INTEGER(18) NOT NULL AUTO_INCREMENT,
    											treatment_key			VARCHAR(250),
    											description 			VARCHAR(1000),
    											drug_administered		TINYINT(1),
    											treatment_administered	TINYINT(1),
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

-------------------------------------*********************************-------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- CREATE CCM-RELATED TABLE: sl_ccm_assessment_analytics
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
CREATE TABLE IF NOT EXISTS sl_ccm_assessment_analytics (
													id 								INTEGER(18) NOT NULL AUTO_INCREMENT,
    												visit_id 						INTEGER(18) NOT NULL,
    												breath_counter_used 			TINYINT(1),
    												breath_full_time_assessment 	TINYINT(1),
    												latitude_location 				VARCHAR(30),
    												longitude_location 				VARCHAR(30),
    												PRIMARY KEY (id),
				    								FOREIGN KEY (visit_id) REFERENCES sl_ccm_patient_visit(visit_id)
												);

-----------------------------------------------------------------------------------------------------------------
-- CLEAN CCM-RELATED TABLE: sl_ccm_assessment_analytics
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
TRUNCATE TABLE sl_ccm_assessment_analytics;
-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------

-------------------------------------*********************************-------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- CREATE CCM-RELATED TABLE: sl_ccm_assessment_sensor
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
CREATE TABLE IF NOT EXISTS sl_ccm_assessment_sensor (
													id 								INTEGER(18) NOT NULL AUTO_INCREMENT,
    												visit_id 						INTEGER(18) NOT NULL,
    												heart_rate 						VARCHAR(30),
    												respiratory_rate 				VARCHAR(30),
    												body_temperature 				VARCHAR(30),
    												PRIMARY KEY (id),
				    								FOREIGN KEY (visit_id) REFERENCES sl_ccm_patient_visit(visit_id)
												);

-----------------------------------------------------------------------------------------------------------------
-- CLEAN CCM-RELATED TABLE: sl_ccm_assessment_sensor
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
TRUNCATE TABLE sl_ccm_assessment_sensor;
-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------


-------------------------------------*********************************-------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- CREATE CCM-RELATED TABLE: sl_contacts
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
CREATE TABLE IF NOT EXISTS sl_contacts (
										id 				INTEGER(18) NOT NULL AUTO_INCREMENT,
    									name 			VARCHAR(100),
    									email 			VARCHAR(100),
    									phone 			VARCHAR(100),
    									comment 		VARCHAR(1000),
    									PRIMARY KEY (id)
										);

-----------------------------------------------------------------------------------------------------------------
-- CLEAN CCM-RELATED TABLE: sl_contacts
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
TRUNCATE TABLE sl_contacts;
-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------


-------------------------------------*********************************-------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- CREATE CCM-RELATED TABLE: sl_newsletter_contacts
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
CREATE TABLE IF NOT EXISTS sl_newsletter_contacts (
										id 				INTEGER(18) NOT NULL AUTO_INCREMENT,
    									email 			VARCHAR(100),
    									PRIMARY KEY (id)
										);

-----------------------------------------------------------------------------------------------------------------
-- CLEAN CCM-RELATED TABLE: sl_newsletter_contacts
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
TRUNCATE TABLE sl_newsletter_contacts;
-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------	