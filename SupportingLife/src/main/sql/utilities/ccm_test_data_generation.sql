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
DELETE FROM sl_ccm_classification;
DELETE FROM sl_ccm_treatment;
DELETE FROM sl_ccm_patient_visit;
DELETE FROM sl_ccm_patient;
DELETE FROM sl_user;
 
-----------------------------------------------------------------------------------------------------------------
-- ADD CCM USER DATA
-----------------------------------------------------------------------------------------------------------------

INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("HSAUSER1", "password", 1, 0, "SELEMI", "FUIAMA", "HSA_USER",
							STR_TO_DATE('14,01,2014','%d,%m,%Y'), STR_TO_DATE('14,01,2014','%d,%m,%Y'));
					
INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("audgrace", "audgrace", 1, 0, "Audrey", "Grace", "HSA_USER",
							STR_TO_DATE('20,06,2014','%d,%m,%Y'), STR_TO_DATE('20,06,2014','%d,%m,%Y'));
							
INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("bchiramb", "bchiramb", 1, 0, "Baxter", "Griphin Chirambo", "HSA_USER",
							STR_TO_DATE('20,06,2014','%d,%m,%Y'), STR_TO_DATE('20,06,2014','%d,%m,%Y'));
							
INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("bandsson", "bandsson", 1, 0, "Bo", "Andersson", "HSA_USER",
							STR_TO_DATE('20,06,2014','%d,%m,%Y'), STR_TO_DATE('20,06,2014','%d,%m,%Y'));

INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("ciheavin", "ciheavin", 1, 0, "Ciara", "Heavin", "HSA_USER",
							STR_TO_DATE('20,06,2014','%d,%m,%Y'), STR_TO_DATE('20,06,2014','%d,%m,%Y'));
							
INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("deirryan", "deirryan", 1, 0, "Deirdre", "Ryan", "HSA_USER",
							STR_TO_DATE('20,06,2014','%d,%m,%Y'), STR_TO_DATE('20,06,2014','%d,%m,%Y'));
					
INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("dnyirong", "dnyirong", 1, 0, "Dominic", "Nyirongo", "HSA_USER",
							STR_TO_DATE('20,06,2014','%d,%m,%Y'), STR_TO_DATE('20,06,2014','%d,%m,%Y'));
				
INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("engaland", "engaland", 1, 0, "Emmanuel", "Ngalande", "HSA_USER",
							STR_TO_DATE('20,06,2014','%d,%m,%Y'), STR_TO_DATE('20,06,2014','%d,%m,%Y'));
							
INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("fredadam", "fredadam", 1, 0, "Frederic", "Adam", "HSA_USER",
							STR_TO_DATE('20,06,2014','%d,%m,%Y'), STR_TO_DATE('20,06,2014','%d,%m,%Y'));
							
INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("jmueller", "jmueller", 1, 0, "Jeanette", "Mueller", "HSA_USER",
							STR_TO_DATE('20,06,2014','%d,%m,%Y'), STR_TO_DATE('20,06,2014','%d,%m,%Y'));				

INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("jenhsieh", "jenhsieh", 1, 0, "Jenny", "Hsieh", "HSA_USER",
							STR_TO_DATE('20,06,2014','%d,%m,%Y'), STR_TO_DATE('20,06,2014','%d,%m,%Y'));
							
INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("jgallagh", "jgallagh", 1, 0, "Joe", "Gallagher", "HSA_USER",
							STR_TO_DATE('20,06,2014','%d,%m,%Y'), STR_TO_DATE('20,06,2014','%d,%m,%Y'));

INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("jodonogh", "jodonogh", 1, 0, "John", "O Donoghue", "HSA_USER",
							STR_TO_DATE('20,06,2014','%d,%m,%Y'), STR_TO_DATE('20,06,2014','%d,%m,%Y'));

INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("josephwu", "josephwu", 1, 0, "Joseph", "Wu", "HSA_USER",
							STR_TO_DATE('20,06,2014','%d,%m,%Y'), STR_TO_DATE('20,06,2014','%d,%m,%Y'));
							
INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("khackett", "khackett", 1, 0, "Keith", "Hackett", "HSA_USER",
							STR_TO_DATE('26,09,2014','%d,%m,%Y'), STR_TO_DATE('26,09,2014','%d,%m,%Y'));

INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("laurdaly", "laurdaly", 1, 0, "Laura", "Daly", "HSA_USER",
							STR_TO_DATE('20,06,2014','%d,%m,%Y'), STR_TO_DATE('20,06,2014','%d,%m,%Y'));
							
INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("mthompsn", "mthompsn", 1, 0, "Matthew", "Thompson", "HSA_USER",
							STR_TO_DATE('20,06,2014','%d,%m,%Y'), STR_TO_DATE('20,06,2014','%d,%m,%Y'));
							
INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("nchimbat", "nchimbat", 1, 0, "Nathaniel", "Chimbatata", "HSA_USER",
							STR_TO_DATE('20,06,2014','%d,%m,%Y'), STR_TO_DATE('20,06,2014','%d,%m,%Y'));
							
INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("natwamba", "natwamba", 1, 0, "Nathalis", "Wamba", "HSA_USER",
							STR_TO_DATE('20,06,2014','%d,%m,%Y'), STR_TO_DATE('20,06,2014','%d,%m,%Y'));							
							
INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("nholmber", "nholmber", 1, 0, "Nicklas", "Holmberg", "HSA_USER",
							STR_TO_DATE('20,06,2014','%d,%m,%Y'), STR_TO_DATE('20,06,2014','%d,%m,%Y'));
							
INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("oddsteen", "oddsteen", 1, 0, "Odd", "Steen", "HSA_USER",
							STR_TO_DATE('20,06,2014','%d,%m,%Y'), STR_TO_DATE('20,06,2014','%d,%m,%Y'));
							
INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("scastell", "scastell", 1, 0, "Sarah", "Castelli", "HSA_USER",
							STR_TO_DATE('20,06,2014','%d,%m,%Y'), STR_TO_DATE('20,06,2014','%d,%m,%Y'));
							
INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("swoodrth", "swoodrth", 1, 0, "Simon", "Woodworth", "HSA_USER",
							STR_TO_DATE('20,06,2014','%d,%m,%Y'), STR_TO_DATE('20,06,2014','%d,%m,%Y'));
							
INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("soconnor", "soconnor", 1, 0, "Siobhan", "O Connor", "HSA_USER",
							STR_TO_DATE('20,06,2014','%d,%m,%Y'), STR_TO_DATE('20,06,2014','%d,%m,%Y'));
							
INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("scarlson", "scarlson", 1, 0, "Sven", "Carlsson", "HSA_USER",
							STR_TO_DATE('20,06,2014','%d,%m,%Y'), STR_TO_DATE('20,06,2014','%d,%m,%Y'));
							
INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("tosulliv", "tosulliv", 1, 0, "Tim", "O Sullivan", "HSA_USER",
							STR_TO_DATE('20,06,2014','%d,%m,%Y'), STR_TO_DATE('20,06,2014','%d,%m,%Y'));
							
INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("tkawonga", "tkawonga", 1, 0, "Tiwonge", "Kawonga", "HSA_USER",
							STR_TO_DATE('20,06,2014','%d,%m,%Y'), STR_TO_DATE('20,06,2014','%d,%m,%Y'));							

INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("vichardy", "vichardy", 1, 0, "Victoria", "Hardy", "HSA_USER",
							STR_TO_DATE('20,06,2014','%d,%m,%Y'), STR_TO_DATE('20,06,2014','%d,%m,%Y'));							

INSERT INTO sl_user(user_id, password, ccm_user, imci_user, first_name, surname, role,
					created_dt, updated_dt) 
					VALUES ("yoconnor", "yoconnor", 1, 0, "Yvonne", "O Connor", "HSA_USER",
							STR_TO_DATE('20,06,2014','%d,%m,%Y'), STR_TO_DATE('20,06,2014','%d,%m,%Y'));		
							
							
-----------------------------------------------------------------------------------------------------------------
-- ADD CCM PATIENT DATA
-----------------------------------------------------------------------------------------------------------------

INSERT INTO sl_ccm_patient(patient_id, national_id, national_health_id, 
							child_first_name, child_surname, date_of_birth, age_months, gender, caregiver_name,
							relationship, physical_address, village_ta, created_dt, updated_dt) 
							VALUES (NULL, "12A", "15FFFF", "JOHN", "SMITH", STR_TO_DATE('18,05,2009','%d,%m,%Y'), 
									46, "MALE", "CAREGIVER 1", "MOTHER", "ADDRESS 1", "VILLAGE 1",
									STR_TO_DATE('13,01,2014','%d,%m,%Y'), STR_TO_DATE('13,01,2014','%d,%m,%Y'));
										   
INSERT INTO sl_ccm_patient(patient_id, national_id, national_health_id,
							child_first_name, child_surname, date_of_birth, age_months, gender, caregiver_name,
							relationship, physical_address, village_ta, created_dt, updated_dt) 
							VALUES (NULL, "16D", "65RFHR", "JULIE", "SMITH", STR_TO_DATE('20,08,2010','%d,%m,%Y'), 
									34, "FEMALE", "CAREGIVER 2", "FATHER", "ADDRESS 2", "VILLAGE 2",
									 STR_TO_DATE('14,01,2014','%d,%m,%Y'), STR_TO_DATE('14,01,2014','%d,%m,%Y'));

INSERT INTO sl_ccm_patient(patient_id, national_id, national_health_id,
							child_first_name, child_surname, date_of_birth, age_months, gender, caregiver_name,
							relationship, physical_address, village_ta, created_dt, updated_dt) 
							VALUES (NULL, "134D", "65RDEF", "SAM", "SMITH", STR_TO_DATE('21,03,2011','%d,%m,%Y'), 
									28, "MALE", "CAREGIVER 3", "FATHER", "ADDRESS 3", "VILLAGE 3",
									 STR_TO_DATE('14,02,2013','%d,%m,%Y'), STR_TO_DATE('14,02,2013','%d,%m,%Y'));

INSERT INTO sl_ccm_patient(patient_id, national_id, national_health_id,
							child_first_name, child_surname, date_of_birth, age_months, gender, caregiver_name,
							relationship, physical_address, village_ta, created_dt, updated_dt) 
							VALUES (NULL, "123M", "99RDEF", "MATT", "DUCHA", STR_TO_DATE('24,04,2011','%d,%m,%Y'), 
									27, "MALE", "CAREGIVER 4", "FATHER", "ADDRESS 4", "VILLAGE 4",
									 STR_TO_DATE('14,04,2013','%d,%m,%Y'), STR_TO_DATE('14,04,2013','%d,%m,%Y'));

INSERT INTO sl_ccm_patient(patient_id, national_id, national_health_id,
							child_first_name, child_surname, date_of_birth, age_months, gender, caregiver_name,
							relationship, physical_address, village_ta, created_dt, updated_dt) 
							VALUES (NULL, "134W", "90RXXF", "JUNE", "DUCHA", STR_TO_DATE('24,04,2011','%d,%m,%Y'), 
									27, "MALE", "CAREGIVER 5", "FATHER", "ADDRESS 5", "VILLAGE 5",
									 STR_TO_DATE('15,05,2013','%d,%m,%Y'), STR_TO_DATE('15,05,2013','%d,%m,%Y'));					 
				
									 
-----------------------------------------------------------------------------------------------------------------
-- ADD CCM PATIENT VISIT DATA
-----------------------------------------------------------------------------------------------------------------									 
								 
INSERT INTO sl_ccm_patient_visit(visit_id, device_generated_id, patient_id, visit_dt, user_id) 
									VALUES (NULL, "", 1, STR_TO_DATE('15,01,2014','%d,%m,%Y'), "hsauser1");
									
INSERT INTO sl_ccm_patient_visit(visit_id, device_generated_id, patient_id, visit_dt, user_id) 
									VALUES (NULL, "", 2, STR_TO_DATE('01,02,2014','%d,%m,%Y'), "hsauser1");
						
--*** patient 1 'Look' symptoms
INSERT INTO sl_ccm_look_symptoms(visit_id, patient_id, chest_indrawing, breaths_per_minute, 
								 sleepy_unconscious, palmar_pallor, muac_tape_colour, swelling_both_feet) 
									VALUES (1, 1, 0, 38, 0, 0, 'GREEN', 0);

--*** patient 2 'Look' symptoms
INSERT INTO sl_ccm_look_symptoms(visit_id, patient_id, chest_indrawing, breaths_per_minute, 
								 sleepy_unconscious, palmar_pallor, muac_tape_colour, swelling_both_feet) 
									VALUES (2, 2, 1, 44, 0, 1, 'GREEN', 1);
						
									
--*** patient 1 has 'Ask and Look' symptoms:'cough for 30 days' & 'convulsions'									
INSERT INTO sl_ccm_ask_look_symptoms(visit_id, patient_id, problem, cough, cough_duration, diarrhoea, diarrhoea_duration,
								 		blood_in_stool, fever, fever_duration, convulsions, difficulty_drink_feed,
								 		not_able_drink_feed, vomiting, vomits_everything, red_eye, red_eye_duration,
								 		difficulty_in_seeing, difficulty_in_seeing_duration, other_problems) 
									VALUES (1, 1, "patient has bad cough and convulsions", 1, 30, 0, NULL,
											0, 0, NULL, 1, 0,
											0, 0, 0, 0, NULL,
											0, NULL, NULL);
											
--*** patient 2 has 'Ask and Look' symptoms:'cough for 30 days' & 'convulsions'									
INSERT INTO sl_ccm_ask_look_symptoms(visit_id, patient_id, problem, cough, cough_duration, diarrhoea, diarrhoea_duration,
								 		blood_in_stool, fever, fever_duration, convulsions, difficulty_drink_feed,
								 		not_able_drink_feed, vomiting, vomits_everything, red_eye, red_eye_duration,
								 		difficulty_in_seeing, difficulty_in_seeing_duration, other_problems) 
									VALUES (2, 2, "chest problems and swelled feet", 0, NULL, 0, NULL,
											1, 0, NULL, 0, 0,
											0, 1, 1, 0, NULL,
											0, NULL, NULL);			
									
												   
-------------------------------------*********************************-------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- ADD CCM CLASSIFICATIONS TEST DATA
-----------------------------------------------------------------------------------------------------------------									 
--*** patient 1 classifications: 'cough for 21 days or more' & 'convulsions'
INSERT INTO sl_ccm_classification(classification_key, classification_name) 
									VALUES ("CCM_COUGH_FOR_21_DAYS_OR_MORE_CLASSIFICATION", "Cough for 21 Days or more"),
										   ("CCM_CONVULSIONS_CLASSIFICATION", "Convulsions");

INSERT INTO sl_ccm_patient_classification(visit_id, patient_id, classification_id) 
											VALUES (1, 1, 1), 
												   (1, 1, 2);
												 
--*** patient 2 classifications: 'palmar pallor, vomits everything, blood in stool, swelling of both feet, chest indrawing'
INSERT INTO sl_ccm_classification(classification_key, classification_name) 
									VALUES ("CCM_PALMAR_PALLOR_CLASSIFICATION", "Palmar Pallor"),
										   ("CCM_VOMITS_EVERYTHING_CLASSIFICATION", "Vomits Everything"),
										   ("CCM_BLOOD_IN_STOOL_CLASSIFICATION", "Blood in Stool"),
										   ("CCM_SWELLING_OF_BOTH_FEET_CLASSIFICATION", "Swelling of Both Feet"),
										   ("CCM_CHEST_INDRAWING_CLASSIFICATION", "Chest Indrawing");

INSERT INTO sl_ccm_patient_classification(visit_id, patient_id, classification_id) 
											VALUES (2, 2, 3), 
												   (2, 2, 4),
												   (2, 2, 5), 
												   (2, 2, 6),
												   (2, 2, 7);
-------------------------------------*********************************-------------------------------------------										   
-----------------------------------------------------------------------------------------------------------------
-- ADD CCM TREATMENTS TEST DATA
-----------------------------------------------------------------------------------------------------------------										 						 
--*** patient 1 treatments
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
												   
--*** patient 2 treatments
INSERT INTO sl_ccm_treatment(treatment_key, description)
								VALUES ("CCM_DANGER_SIGN_REFER_URGENTLY_TREATMENT", "REFER URGENTLY to health facility"),
									   ("CCM_DANGER_SIGN_EXPLAIN_REFERRAL_TREATMENT", "Explain why child needs to go to health facility"),
									   ("CCM_DANGER_SIGN_FLUIDS_AND_FEEDING_TREATMENT", "Advise to give fluids and continue feeding"),
									   ("CCM_DANGER_SIGN_KEEP_CHILD_WARM_TREATMENT", "Advise to keep child warm, if 'child is NOT hot with fever'"),
									   ("CCM_DANGER_SIGN_REFERRAL_NOTE_TREATMENT", "Write a referral note"),	 
									   ("CCM_DANGER_SIGN_TRANSPORTATION_TREATMENT", "Arrange transportation and help solve other difficulties in referral");	 
											 
											 
INSERT INTO sl_ccm_patient_treatment(visit_id, patient_id, treatment_id) 
											VALUES (2, 2, 7), 
												   (2, 2, 8),
												   (2, 2, 9),
												   (2, 2, 10),
												   (2, 2, 11),
												   (2, 2, 12);

-----------------------------------------------------------------------------------------------------------------
-- ADD CCM ASSESSMENT ANALYTICS DATA
-----------------------------------------------------------------------------------------------------------------									 
								 
INSERT INTO sl_ccm_assessment_analytics(visit_id, breath_counter_used, breath_full_time_assessment, latitude_location, longitude_location) 
									VALUES (1, 1, 0, "51.8926846", "-8.490176");
									
INSERT INTO sl_ccm_assessment_analytics(visit_id, breath_counter_used, breath_full_time_assessment, latitude_location, longitude_location) 
									VALUES (2, 1, 0, "53.9426846", "-6.490155");

									
-----------------------------------------------------------------------------------------------------------------
-- ADD CCM ASSESSMENT 'SENSOR READING' DATA
-----------------------------------------------------------------------------------------------------------------									 
								 
INSERT INTO sl_ccm_assessment_sensor(visit_id, heart_rate, respiratory_rate, body_temperature) 
									VALUES (1, "63", "32", "31.2");
									
INSERT INTO sl_ccm_assessment_sensor(visit_id, heart_rate, respiratory_rate, body_temperature) 
									VALUES (2, "58", "29", "29.2");