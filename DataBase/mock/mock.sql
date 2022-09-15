insert into type_bedroom(bedroom_type) values
    ('familliale'),
    ('couple');

insert into type_hotel(hotel_type) values
    ('PRENIUM'),
    ('MEDIUM');

insert into type_location(location_type) values
    ('MEDIUM'),('PRENIUM'),('PROMOTION');

insert into hotel(location, name_hotel, type_hotel_id_hotel_type, image_1, image_2, logo) values
    ('Antananarivo', 'carlton', 2, 'carlton_2.jpg', 'carlton_3.jpeg', 'hotel_carlton_logo.jpg'),
    ('Antananarivo', 'centell', 1, 'centell_2.jpg', 'centell_3.jpg', 'hotel_centell_tana_logo.png'),
    ('Antananarivo', 'colbert', 2, 'colbert_2.jpg', 'colbert_3.jpg', 'hotel_colbert_tana_logo.jpg'),
    ('Antananarivo', 'louvre', 1, 'louvre_2.jpg', 'louvre_3.jpg', 'hotel_leLouvre_tana_logo.png'),
    ('Antananarivo', 'radisson', 1, 'radisson_2.jpg', 'radisson_3.jpg', 'hotel_radisson_tana_logo.jpg'),
    ('Nosy-Be', 'anjamarango', 1, 'anjamarango_2.jpg', 'anjamarango_3.jpg', 'anjamarango_hotel_logo.png'),
    ('Nosy-Be', 'palm-beach', 1, 'palm_beach_1.jpg', 'palm_beach_2.jpg', 'palm-beach-resort-Spa_logo.jpg'),
    ('Nosy-Be','vanilla', 1, 'vanila_hotel_2.jpg', 'vanila_hotel_3.jpg', 'vanila_logo.jpg'),
    ('Majunga','baobab', 1, 'baobab_2.jpeg', 'baobab_3.jpg', 'baobab_logo.jpg'),
    ('Majunga','pap', 1, 'paps_2.jpg', 'pap_3.jpg', 'pap_hotes_logo.jpg');

insert into bedroom(hotel, location_price, reserved, type_location_id_location_type, hotel_logo) values 
    ('carlton', 185000, false, 3, 'hotel_carlton_logo.jpg'),
    ('centell', 300000, true, 2, 'hotel_centell_tana_logo.png'),
    ('colbert', 95000, true, 1, 'hotel_colbert_tana_logo.jpg'),
    ('louvre', 100000, false, 1, 'hotel_leLouvre_tana_logo.png'),
    ('radisson', 250000, false, 1, 'hotel_radisson_tana_logo.jpg'),
    ('anjamarango', 600000, true, 1, 'anjamarango_hotel_logo.png'),
    ('palm-beach', 550000, false, 1, 'palm-beach-resort-Spa_logo.jpg'),
    ('vanilla', 475000, true, 1, 'vanila_logo.jpg'),
    ('baobab', 350000, true, 1, 'baobab_logo.jpg'),
    ('pap', 375000, false, 1, 'pap_hotes_logo.jpg');

insert into country(country_name) values
    ('Antananarivo'),
    ('Nosy-Be'),
    ('Majunga');