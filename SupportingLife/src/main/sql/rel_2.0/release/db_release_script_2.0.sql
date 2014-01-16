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
										 	patient_id 			INTEGER(18) NOT NULL AUTO_INCREMENT,
    										user_id 			VARCHAR(8),
    										child_first_name 	VARCHAR(50),
    										child_surname 		VARCHAR(50),
    										date_of_birth 		DATE,
    										gender 				VARCHAR(6),
    										caregiver_name 		VARCHAR(100),
    										relationship 		VARCHAR(7),
    										other_relationship 	VARCHAR(50),
    										physical_address 	VARCHAR(250),
    										village_ta 			VARCHAR(50),
    										created_dt 			TIMESTAMP,
    										updated_dt 			TIMESTAMP,
    										PRIMARY KEY (patient_id),
                       						FOREIGN KEY (user_id) REFERENCES sl_user(user_id)
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
    												visit_id 		INTEGER(18) NOT NULL AUTO_INCREMENT,
    												patient_id 		INTEGER(18) NOT NULL,
    												follow_up_id 	INTEGER(18),
    												visit_dt 		DATE,
				    								PRIMARY KEY (visit_id),
				    								FOREIGN KEY (patient_id) REFERENCES sl_ccm_patient(patient_id)
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
    												classification_id 	INTEGER(18) NOT NULL,
    												name 				VARCHAR(250),
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
    												visit_id 			INTEGER(18) NOT NULL,
    												patient_id 			INTEGER(18) NOT NULL,
    												classification_id 	INTEGER(18) NOT NULL,
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
    											treatment_id 		INTEGER(18) NOT NULL,
    											description 		VARCHAR(100),
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
    												visit_id 		INTEGER(18) NOT NULL,
    												patient_id 		INTEGER(18) NOT NULL,
    												treatment_id 	INTEGER(18) NOT NULL,
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
    												visit_id 			INTEGER(18) NOT NULL,
    												patient_id 			INTEGER(18) NOT NULL,
    												chest_indrawing 	TINYINT(1),
    												breaths_per_minute 	INTEGER(4),
    												sleepy_unconscious 	TINYINT(1),
    												palmar_pallor	 	TINYINT(1),
    												muac_tap_colour 	VARCHAR(7),
    												swelling_both_feet 	TINYINT(1),
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
-- ADD CCM CLASSIFICATIONS (REQUIRED DATA)
-----------------------------------------------------------------------------------------------------------------									 

INSERT INTO sl_ccm_classification(classification_id, name) 
									VALUES (1, "COUGH_FOR_21_DAYS_OR_MORE_CLASSIFICATION"),
										   (2, "DIARRHOEA_FOR_14_DAYS_OR_MORE_CLASSIFICATION"),
										   (3, "BLOOD_IN_STOOL_CLASSIFICATION"),
										   (4, "DIARRHOEA_LESS_THAN_14_DAYS_AND_NO_BLOOD_IN_STOOL_CLASSIFICATION"),
										   (5, "FEVER_FOR_LAST_7_DAYS_CLASSIFICATION"),
										   (6, "FEVER_FOR_LESS_THAN_7_DAYS_CLASSIFICATION"),
										   (7, "CONVULSIONS_CLASSIFICATION"),
										   (8, "NOT_ABLE_TO_DRINK_OR_FEED_ANYTHING_CLASSIFICATION"),
										   (9, "VOMITS_EVERYTHING_CLASSIFICATION"),
										   (10, "RED_EYE_FOR_4_DAYS_OR_MORE_CLASSIFICATION"),
										   (11, "RED_EYE_WITH_VISUAL_PROBLEMS_CLASSIFICATION"),
										   (12, "RED_EYE_LESS_THAN_4_DAYS_CLASSIFICATION"),
										   (13, "OTHER_PROBLEM_CLASSIFICATION"),
										   (14, "CHEST_INDRAWING_CLASSIFICATION"),
										   (15, "FAST_BREATHING_CLASSIFICATION"),
										   (16, "VERY_SLEEPY_OR_UNCONSCIOUS_CLASSIFICATION"),
										   (17, "PALMAR_PALLOR_CLASSIFICATION"),
										   (18, "RED_ON_MUAC_TAPE_CLASSIFICATION"),
										   (19, "SWELLING_OF_BOTH_FEET_CLASSIFICATION");

										   
-------------------------------------*********************************-------------------------------------------										   
-----------------------------------------------------------------------------------------------------------------
-- ADD CCM TREATMENTS (REQUIRED DATA) --> NEED TO WORK OUT HOW TO HANDLE TREATMENTS IN CCM
-----------------------------------------------------------------------------------------------------------------		


										   
										   
										   