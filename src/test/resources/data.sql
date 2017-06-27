INSERT INTO journals (journal_id, path, seq, primary_locale, enabled) VALUES (1, 'path-context', 1, 'en_US', 1);

INSERT INTO  journals (journal_id, path, seq, primary_locale, enabled) VALUES(2, 'path-context', 1, 'en_US', 1);

INSERT INTO  journals (journal_id, path, seq, primary_locale, enabled) VALUES(3, 'path-context', 1, 'en_US', 0);

INSERT INTO journal_settings (journal_id, locale, setting_name, setting_value, setting_type) VALUES (1, 'en_US', 'supportedLocales', 'a:3:{i:0;s:5:\"fr_CA\";i:1;s:5:\"ar_IQ\";i:2;s:5:\"en_US\";}', 'object'),
 (1, 'en_US', 'additionalHomeContent', '<p>additinal context</p>', 'string');
-- (1, 'en_US', 'authorGuidelines', '<p>Recommended guidelines include bibliographic and formatting standards alongside examples of common citation formats to be used in submissions.</p>', 'string'),
-- (1, 'en_US', 'customHeaders', 'Custom HTML header tags to be inserted in the header of every page (e.g., META tags).', 'string'),
-- (1, 'en_US', 'description', '<p>the journal description</p>', 'string'),
-- (1, 'en_US', 'donationFeeDescription', 'Donations of any amount to this journal are gratefully received and provide a means for the editors to continue to provide a journal of the highest quality to its readers.', 'string'),
-- (1, 'en_US', 'donationFeeName', 'Donations to journal', 'string');