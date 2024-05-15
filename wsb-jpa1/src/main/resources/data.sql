insert into address (id, address_line1, address_line2, city, postal_code)
    values
        (1, 'xx', 'yy', 'city', '62-030'),
        (2, '726 Jackson Alley', 'Room 638', 'Jamao al Norte', '1013'),
        (3, '119 Mcbride Place', '3rd Floor', 'Thị Trấn Bình Mỹ', '12445'),
        (4, '0 Talmadge Court', 'Apt 1152', 'Orhei', 'MD-354'),
        (5, '1635 Arrowood Center', 'Room 60', 'Marco', '62560-00'),
        (6, '46 North Lane', '17th Floor', 'Góis', '3330-30'),
        (7, '58687 Sutherland Way', 'PO Box 85228', 'Chrást', '330 0'),
        (8, '9 7th Circle', 'Suite 13', 'Laon', '02004 CEDE'),
        (9, '906 Haas Pass', '9th Floor', 'Helie', '2134-324'),
        (10, '515 Ridge Oak Trail', 'Room 1100', 'Chitose', '990-081'),
        (11, '44 Lindbergh Trail', 'Suite 99', 'Tatrang', '345-345'),
        (12, '014 Lake View Circle', 'Room 1813', 'Primorka', '34687'),
        (13, '4470 Darwin Drive', 'PO Box 32539', 'Nasilava', '234234'),
        (14, '82 Milwaukee Plaza', 'Suite 97', 'Irbid', '2342345-3'),
        (15, '37231 Waywood Hill', 'Apt 1914', 'Tanghua', '234-34'),
        (16, '2 Claremont Parkway', '18th Floor', 'Santa Rosa', '32-232'),
        (17, '72474 Hooker Trail', '19th Floor', 'Yong’an', '2335'),
        (18, '1162 Bobwhite Plaza', 'Suite 87', 'Waco', '7679'),
        (19, '4762 Hermina Alley', 'Apt 1489', 'Kärdla', '23-234'),
        (20, '69 8th Lane', 'Apt 966', 'Laraos', '112');


insert into patient (id, date_of_birth, email, first_name, last_name, patient_number, telephone_number, address_id, has_insurance)
values
    (1, '2024-03-04', 'gremer0@list-manage.com', 'Gaelan', 'Remer', '2018458035', '934-189-3363', 1, true),
    (2, '2024-02-21', null, 'Morlee', 'Geraldi', '1772116149', '159-818-4909', 2, false),
    (3, '2024-05-30', 'clivett2@hatena.ne.jp', 'Calida', 'Livett', '1959939106', '801-993-6384', 3, true),
    (4, '2023-08-12', 'frountree3@uiuc.edu', 'Fawne', 'Rountree', '1644615487', '573-991-6951', 4, true),
    (5, '2023-07-11', 'dmattiussi4@skyrock.com', 'Derrick', 'Mattiussi', '3010703457', '285-283-8076', 5, false),
    (6, '2024-05-14', 'rreaveley5@usgs.gov', 'Renate', 'Reaveley', '4433378305', '474-944-5407', 6, true),
    (7, '2023-08-05', 'ggaiger6@hugedomains.com', 'Gay', 'Gaiger', '6734395960', '913-156-6741', 7, true),
    (8, '2023-06-15', 'rmcnickle7@smugmug.com', 'Russ', 'McNickle', '5165592847', '640-256-9500', 8, true),
    (9, '2024-02-28', 'oscemp8@jalbum.net', 'Oberon', 'Scemp', '5618018012', '798-387-8668', 9, true),
    (10, '2023-08-10', 'jgegay9@loc.gov', 'Jasen', 'Gegay', '3773199538', '875-865-7039', 10, false);

insert into doctor (id, doctor_number, email, first_name, last_name, specialization, telephone_number, address_id)
values
    (1, '9772957299', 'gnorker0@google.it', 'Gerik', 'Norker', 'SURGEON', '946-289-7266', 11),
    (2, '5123832106', 'aalldritt1@youku.com', 'Aurora', 'Alldritt', 'OCULIST', '968-737-8440', 12),
    (3, '4449456165', 'cspiers2@cbslocal.com', 'Cordie', 'Spiers', 'DERMATOLOGIST', '285-289-6378', 13),
    (4, '1087868165', null, 'Derk', 'Dignum', 'SURGEON', '274-402-2578', 14),
    (5, '5413351135', 'lsnuggs4@rediff.com', 'Letti', 'Snuggs', 'GP', '283-809-3610', 15),
    (6, '8727213498', 'agamil5@netscape.com', 'Aksel', 'Gamil', 'SURGEON', '814-799-6850', 16),
    (7, '9476663510', 'llivingston6@slate.com', 'Lenora', 'Livingston', 'GP', '657-642-5149', 17),
    (8, '3431385540', null, 'Rivi', 'Menci', 'DERMATOLOGIST', '739-106-7475', 18),
    (9, '0752249568', 'dforgie8@unesco.org', 'Dick', 'Forgie', 'OCULIST', '794-853-8114', 19),
    (10, '1036546454', 'jdavidek9@dagondesign.com', 'Joycelin', 'Davidek', 'GP', '330-898-6858', 20);

insert into visit (id, description, time, doctor_id, patient_id)
values
    (1, 'Proactive dedicated neural-net', '2024-03-27 13:29:29', 1, 1),
    (2, 'Diverse asymmetric middleware', '2023-05-20 07:46:35', 2, 2),
    (3, 'Up-sized fault-tolerant hierarchy', '2024-02-05 14:34:01', 3, 3),
    (4, 'Organized directional groupware', '2024-02-09 18:29:09', 4, 4),
    (5, 'Cloned impactful installation', '2023-11-07 19:51:42', 5, 5),
    (6, 'Inverse encompassing productivity', '2024-04-12 00:48:39', 6, 6),
    (7, 'Self-enabling needs-based knowledge user', '2023-07-24 02:20:05', 7, 7),
    (8, 'Balanced upward-trending secured line', '2023-11-07 20:04:35', 8, 8),
    (9, 'Synchronised even-keeled matrices', '2024-02-02 15:54:41', 9, 9),
    (10, 'Vision-oriented directional policy', '2024-02-22 16:34:10', 10, 10),
    (11, 'No dedicated doctor', '2024-04-27 13:29:29', 2, 1);

insert into medical_treatment (id, description, type, visit_id)
    values
        (1, '5556 Russell Court', 'USG', 1),
        (2, '87655 Messerschmidt Junction', 'EKG', 2),
        (3, '3369 Mesta Crossing', 'USG', 3),
        (4, '57 Coolidge Parkway', 'RTG', 4),
        (5, '2388 Everett Way', 'RTG', 5),
        (6, '5 Northland Circle', 'USG', 6),
        (7, '19023 Iowa Pass', 'EKG', 7),
        (8, '9 Lindbergh Crossing', 'USG', 8),
        (9, '82 Artisan Alley', 'RTG', 9),
        (10, '8721 Artisan Alley', 'RTG', 10),
        (11, 'Arrow in the knee', 'RTG', 11);
