-----------------------------------------------------------------------------------------------------------------
-- CCM TEST DATA GENERATION
-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- CLEAN TABLES
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
DELETE FROM sl_ccm_patient;
DELETE FROM sl_user;

-----------------------------------------------------------------------------------------------------------------
-- ADD USER DATA
-----------------------------------------------------------------------------------------------------------------

INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("hsauser1", "password", 1, 0, "Selemi", "Fuiama", "HSA_USER",
							STR_TO_DATE('14,01,2014','%d,%m,%Y'), STR_TO_DATE('14,01,2014','%d,%m,%Y'));
							

-----------------------------------------------------------------------------------------------------------------
-- ADD CCM PATIENT DATA
-----------------------------------------------------------------------------------------------------------------

INSERT INTO sl_ccm_patient(patient_id, user_id, first_name, surname, date_of_birth, gender, caregiver_name, relationship,
							other_relationship, physical_address, village_ta, created_dt, updated_dt) 
							VALUES (NULL, "hsauser1", "JOHN", "SMITH", STR_TO_DATE('18,05,2009','%d,%m,%Y'), 
									"male", "care_giver_name", "MOTHER", NULL, "physical address", "village ta",
									STR_TO_DATE('13,01,2014','%d,%m,%Y'), STR_TO_DATE('13,01,2014','%d,%m,%Y'));
										   
INSERT INTO sl_ccm_patient(patient_id, user_id, first_name, surname, date_of_birth, gender, caregiver_name, relationship,
							other_relationship, physical_address, village_ta, created_dt, updated_dt) 
							VALUES (NULL, "hsauser1", "JULIE", "SMITH", STR_TO_DATE('20,08,2010','%d,%m,%Y'), 
									"female", "care_giver_name", "FATHER", NULL, "physical address", "village ta",
									 STR_TO_DATE('14,01,2014','%d,%m,%Y'), STR_TO_DATE('14,01,2014','%d,%m,%Y'));


-----------------------------------------------------------------------------------------------------------------
-- ADD CCM PATIENT VISIT DATA
-----------------------------------------------------------------------------------------------------------------									 



									 