INSERT INTO journals (journal_id, path, seq, primary_locale, enabled) VALUES (1, 'path-context', 1, 'en_US', 1);

INSERT INTO  journals (journal_id, path, seq, primary_locale, enabled) VALUES(2, 'path-context-2', 1, 'en_US', 1);

INSERT INTO  journals (journal_id, path, seq, primary_locale, enabled) VALUES(3, 'path-context-3', 1, 'en_US', 0);

INSERT INTO journal_settings (journal_id, locale, setting_name, setting_value, setting_type) VALUES (1, 'en_US', 'supportedLocales', 'a:3:{i:0;s:5:\"fr_CA\";i:1;s:5:\"ar_IQ\";i:2;s:5:\"en_US\";}', 'object'),
 (1, 'en_US', 'additionalHomeContent', '<p>additinal context</p>', 'string'),
 (1, 'en_US', 'authorGuidelines', '<p>Recommended guidelines include bibliographic and formatting standards alongside examples of common citation formats to be used in submissions.</p>', 'string'),
 (1, 'en_US', 'customHeaders', 'Custom HTML header tags to be inserted in the header of every page (e.g., META tags).', 'string'),
 (1, 'en_US', 'description', '<p>the journal description</p>', 'string'),
 (2, 'en_US', 'description', '<p>the journal description 2</p>', 'string'),
 (1, 'en_US', 'searchDescription', 'brief description of the journal which search engines can display when listing the journal in search results.', 'string'),
 (2, 'en_US', 'searchDescription', 'brief description.', 'string'),
 (1, 'en_US', 'abbreviation', 'Journal Abbreviation', 'string'),
 (1, 'en_US', 'name', 'Test default name', 'string'),
 (1, '', 'contactEmail', 'journal-contact@yahoo.fr', 'string'),
 (1, '', 'contactName', 'dupon jard', 'string'),
 (1, '', 'contactPhone', '0778965404', 'string'),
 (1, 'en_US', 'contactAffiliation', 'this is affliated to global journal', 'string'),
 (1, 'en_US', 'contactTitle', 'DR', 'string'),
 (1, 'en_US', 'donationFeeDescription', 'Donations of any amount to this journal are gratefully received and provide a means for the editors to continue to provide a journal of the highest quality to its readers.', 'string'),
 (1, 'en_US', 'donationFeeName', 'Donations to journal', 'string'),
 (1, '', 'onlineIssn', '1365-2435', 'string'),
 (1, '', 'printIssn', '1365-2425', 'string'),
 (1, '', 'publisherInstitution', 'name of the organization publishing the journal', 'string');
 
 
 INSERT INTO issues (issue_id, journal_id, volume, number, year, published, current, date_published, date_notified, last_modified, access_status, open_access_date, show_volume, show_number, show_year, show_title, style_file_name, original_style_file_name) VALUES
(1, 1, 3, '12', 2016, 1, 1, '2017-06-29 15:18:00', '2017-07-22 11:12:05', '2017-06-29 15:18:00', 1, '2017-07-07 07:07:07', 1, 1, 1, 1, 'file1','org file');

 INSERT INTO issues (issue_id, journal_id, volume, number, year, published, current, date_published, date_notified, last_modified, access_status, open_access_date, show_volume, show_number, show_year, show_title, style_file_name, original_style_file_name) VALUES
(2, 1, 1, '13', 2016, 0, 1, '2017-06-29 15:18:00', NULL, '2017-06-29 15:18:00', 1, NULL, 1, 1, 1, 1, NULL, NULL);

 INSERT INTO issues (issue_id, journal_id, volume, number, year, published, current, date_published, date_notified, last_modified, access_status, open_access_date, show_volume, show_number, show_year, show_title, style_file_name, original_style_file_name) VALUES
(3, 1, 2, '11', 2016, 1, 0, '2017-06-29 15:18:00', NULL, '2017-06-29 15:18:00', 1, NULL, 1, 1, 1, 1, NULL, NULL);


INSERT INTO issue_settings (issue_id, locale, setting_name, setting_value, setting_type) VALUES
(1, '', 'pub-id::publisher-id', 'http://localhost/ojs/index.php/issue-public-url-id', 'string'),
(1, 'en_US', 'coverImage', 'cover_issue_1_en_US.jpg', 'string'),
(1, 'en_US', 'coverImageAltText', 'Alternate text', 'string'),
(1, 'en_US', 'description', '<p>some description of the issue</p>', 'string'),
(1, 'en_US', 'title', 'The title of the issue', 'string');

INSERT INTO submissions (submission_id, locale, context_id, section_id, language, citations, date_submitted, last_modified, date_status_modified, status, submission_progress, current_round, pages, fast_tracked, hide_author, stage_id) VALUES
(1, 'en_US', 1, 1, '', NULL, NULL, '2017-05-15 13:45:38', '2017-05-15 13:45:38', 1, 2, 1, NULL, 0, 0, 1),
(2, 'en_US', 1, 1, '', NULL, '2017-06-16 15:05:54', '2017-06-29 15:18:00', '2017-06-29 15:18:00', 3, 0, 1, '45', 0, 0, 5);


INSERT INTO published_submissions (published_submission_id, submission_id, issue_id, date_published, seq, access_status) VALUES
(1, 2, 1, '2017-06-29 00:00:00', 1, 0);


INSERT INTO submission_settings (submission_id, locale, setting_name, setting_value, setting_type) VALUES
(2, '', 'copyrightYear', '2017', 'string'),
(2, '', 'licenseURL', '', 'string'),
(2, 'en_US', 'abstract', '<p>this is an abstrat</p>\r\n<p>&nbsp;</p>\r\n<p><strong>wiht Bold text </strong></p>', 'string'),
(2, 'en_US', 'cleanTitle', 'article title', 'string'),
(2, 'en_US', 'copyrightHolder', 'Test default 1', 'string'),
(2, 'en_US', 'coverage', 'Coverage Information', 'string'),
(2, 'en_US', 'prefix', 'the preifix', 'string'),
(2, 'en_US', 'subtitle', 'some sub tilte', 'string'),
(2, 'en_US', 'title', 'article title', 'string');