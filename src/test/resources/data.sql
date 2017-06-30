INSERT INTO journals (journal_id, path, seq, primary_locale, enabled) VALUES (1, 'path-context', 1, 'en_US', 1);

INSERT INTO  journals (journal_id, path, seq, primary_locale, enabled) VALUES(2, 'path-context-2', 1, 'en_US', 1);

INSERT INTO  journals (journal_id, path, seq, primary_locale, enabled) VALUES(3, 'path-context-3', 1, 'en_US', 0);

INSERT INTO journal_settings (journal_id, locale, setting_name, setting_value, setting_type) VALUES (1, 'en_US', 'supportedLocales', 'a:3:{i:0;s:5:\"fr_CA\";i:1;s:5:\"ar_IQ\";i:2;s:5:\"en_US\";}', 'object'),
 (1, 'en_US', 'additionalHomeContent', '<p>additinal context</p>', 'string'),
 (1, 'en_US', 'authorGuidelines', '<p>Recommended guidelines include bibliographic and formatting standards alongside examples of common citation formats to be used in submissions.</p>', 'string'),
 (1, 'en_US', 'customHeaders', 'Custom HTML header tags to be inserted in the header of every page (e.g., META tags).', 'string'),
 (1, 'en_US', 'description', '<p>the journal description</p>', 'string'),
 (2, 'en_US', 'description', '<p>the journal description 2</p>', 'string'),
 (1, 'en_US', 'donationFeeDescription', 'Donations of any amount to this journal are gratefully received and provide a means for the editors to continue to provide a journal of the highest quality to its readers.', 'string'),
 (1, 'en_US', 'donationFeeName', 'Donations to journal', 'string');
 
 
 INSERT INTO issues (issue_id, journal_id, volume, number, year, published, current, date_published, date_notified, last_modified, access_status, open_access_date, show_volume, show_number, show_year, show_title, style_file_name, original_style_file_name) VALUES
(1, 1, 3, '12', 2016, 1, 1, '2017-06-29 15:18:00', '2017-07-22 11:12:05', '2017-06-29 15:18:00', 1, '2017-07-07 07:07:07', 1, 1, 1, 1, 'file1','org file');

 INSERT INTO issues (issue_id, journal_id, volume, number, year, published, current, date_published, date_notified, last_modified, access_status, open_access_date, show_volume, show_number, show_year, show_title, style_file_name, original_style_file_name) VALUES
(2, 1, 1, '13', 2016, 0, 1, '2017-06-29 15:18:00', NULL, '2017-06-29 15:18:00', 1, NULL, 1, 1, 1, 1, NULL, NULL);

 INSERT INTO issues (issue_id, journal_id, volume, number, year, published, current, date_published, date_notified, last_modified, access_status, open_access_date, show_volume, show_number, show_year, show_title, style_file_name, original_style_file_name) VALUES
(3, 1, 2, '11', 2016, 1, 0, '2017-06-29 15:18:00', NULL, '2017-06-29 15:18:00', 1, NULL, 1, 1, 1, 1, NULL, NULL);