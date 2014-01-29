-----------------------------------------------------------------------------------------------------------------
-- CCM TEST DATA GENERATION
-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- CLEAN TABLES
-----------------------------------------------------------------------------------------------------------------
USE supportinglifedb;
DELETE FROM sl_ccm_look_symptoms;
DELETE FROM sl_ccm_ask_look_symptoms;
DELETE FROM sl_ccm_patient_classification;
DELETE FROM sl_ccm_patient_treatment;
DELETE FROM sl_ccm_patient_visit;
DELETE FROM sl_ccm_patient;
DELETE FROM sl_user;

-----------------------------------------------------------------------------------------------------------------
-- ADD CCM USER DATA
-----------------------------------------------------------------------------------------------------------------

INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("hsauser1", "password", 1, 0, "Selemi", "Fuiama", "HSA_USER",
							STR_TO_DATE('14,01,2014','%d,%m,%Y'), STR_TO_DATE('14,01,2014','%d,%m,%Y'));
							

-----------------------------------------------------------------------------------------------------------------
-- ADD CCM PATIENT DATA
-----------------------------------------------------------------------------------------------------------------

INSERT INTO sl_ccm_patient(patient_id, national_id, national_health_id, 
							user_id, child_first_name, child_surname, date_of_birth, gender, caregiver_name,
							relationship, other_relationship, physical_address, village_ta, created_dt, updated_dt) 
							VALUES (NULL, "12A", "15F", "hsauser1", "JOHN", "SMITH", STR_TO_DATE('18,05,2009','%d,%m,%Y'), 
									"male", "care_giver_name", "MOTHER", NULL, "physical address", "village ta",
									STR_TO_DATE('13,01,2014','%d,%m,%Y'), STR_TO_DATE('13,01,2014','%d,%m,%Y'));
										   
INSERT INTO sl_ccm_patient(patient_id, national_id, national_health_id,
							user_id, child_first_name, child_surname, date_of_birth, gender, caregiver_name,
							relationship, other_relationship, physical_address, village_ta, created_dt, updated_dt) 
							VALUES (NULL, "16D", "65R", "hsauser1", "JULIE", "SMITH", STR_TO_DATE('20,08,2010','%d,%m,%Y'), 
									"female", "care_giver_name", "FATHER", NULL, "physical address", "village ta",
									 STR_TO_DATE('14,01,2014','%d,%m,%Y'), STR_TO_DATE('14,01,2014','%d,%m,%Y'));


-----------------------------------------------------------------------------------------------------------------
-- ADD CCM PATIENT VISIT DATA
-----------------------------------------------------------------------------------------------------------------									 
								 
INSERT INTO sl_ccm_patient_visit(visit_id, patient_id, visit_dt) 
									VALUES (NULL, 1, STR_TO_DATE('15,01,2014','%d,%m,%Y'));
						
--*** patient has 'Look' symptoms
INSERT INTO sl_ccm_look_symptoms(visit_id, patient_id, chest_indrawing, breaths_per_minute, 
								 sleepy_unconscious, palmar_pallor, muac_tape_colour, swelling_both_feet) 
									VALUES (1, 1, 0, 38, 0, 0, 'GREEN', 0);
						
									
--*** patient has 'Ask and Look' symptoms:'cough for 30 days' & 'convulsions'									
INSERT INTO sl_ccm_ask_look_symptoms(visit_id, patient_id, problem, cough, cough_duration, diarrhoea, diarrhoea_duration,
								 		blood_in_stool, fever, fever_duration, convulsions, difficulty_drink_feed,
								 		not_able_drink_feed, vomiting, vomits_everything, red_eye, red_eye_duration,
								 		difficulty_in_seeing, difficulty_in_seeing_duration, other_problems) 
									VALUES (1, 1, "patient has bad cough and convulsions", 1, 30, 0, NULL,
											0, 0, NULL, 1, 0,
											0, 0, 0, 0, NULL,
											0, NULL, NULL);									
									
												   
-------------------------------------*********************************-------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- ADD CCM CLASSIFICATIONS TEST DATA
-----------------------------------------------------------------------------------------------------------------									 
--*** patient has classifications: 'cough for 21 days or more' & 'convulsions'
INSERT INTO sl_ccm_classification(classification_key, classification_name) 
									VALUES ("CCM_COUGH_FOR_21_DAYS_OR_MORE_CLASSIFICATION", "Cough for 21 Days or more"),
										   ("CCM_CONVULSIONS_CLASSIFICATION", "Convulsions");

INSERT INTO sl_ccm_patient_classification(visit_id, patient_id, classification_id) 
											VALUES (1, 1, 1), 
												   (1, 1, 2);
										   
-------------------------------------*********************************-------------------------------------------										   
-----------------------------------------------------------------------------------------------------------------
-- ADD CCM TREATMENTS TEST DATA
-----------------------------------------------------------------------------------------------------------------										 						 
INSERT INTO sl_ccm_treatment(treatment_key, description)
								VALUES ("CCM_DANGER_SIGN_REFER_URGENTLY_TREATMENT", "REFER URGENTLY to health facility"),
									   ("CCM_DANGER_SIGN_EXPLAIN_REFERRAL_TREATMENT", "Explain why child needs to go to health facility"),
									   ("CCM_DANGER_SIGN_FLUIDS_AND_FEEDING_TREATMENT", "Advise to give fluids and continue feeding"),
									   ("CCM_DANGER_SIGN_KEEP_CHILD_WARM_TREATMENT", "Advise to keep child warm, if 'child is NOT hot with fever'"),
									   ("CCM_DANGER_SIGN_REFERRAL_NOTE_TREATMENT", "Write a referral note"),	 
									   ("CCM_DANGER_SIGN_TRANSPORTATION_TREATMENT", "Arrange transportation and help solve other difficulties in referral");	 
											 
											 
INSERT INTO sl_ccm_patient_treatment(visit_id, patient_id, treatment_id) 
											VALUES (1, 1, 1), 
												   (1, 1, 2),
												   (1, 1, 3),
												   (1, 1, 4),
												   (1, 1, 5),
												   (1, 1, 6);

