insert into type_bedroom(bedroom_type, image) values
    ('familliale', '/bedroom-project/Front-end/front-end-hotel-room/src/components/assets/type-chambre/type_chambre_familliale.jpg'),
    ('couple', '/bedroom-project/Front-end/front-end-hotel-room/src/components/assets/type-chambre/chambre_couple.jpg');

insert into type_hotel(hotel_type, image) values
    ('PRENIUM', '/bedroom-project/Front-end/front-end-hotel-room/src/components/assets/type-chambre/type_hotel_1.jpg'),
    ('MEDIUM', '/bedroom-project/Front-end/front-end-hotel-room/src/components/assets/type-chambre/type_hotel_2.jpg');

insert into type_location(location_type) values
    ('MEDIUM'),('PRENIUM'),('PROMOTION');

insert into hotel(location, name_hotel, type_hotel_id_hotel_type, image_1, image_2, logo) values
    ('Antananarivo', 'carlton', 2, '../../assets/tana/carlton/carlton_2.jpg', '../../assets/tana/carlton/carlton_3.jpeg', '../../assets/tana/carlton/hotel_carlton_tana_logo.jpg'),
    ('Antananarivo', 'centell', 1, '../../assets/tana/centell/centell_2.jpg', '../../assets/tana/centell/centell_3.jpg', '../../assets/tana/centell/hotel_centell_tana_logo.png'),
    ('Antananarivo', 'colbert', 2, '../../assets/tana/colbert/colbert_2.jpg', '../../assets/tana/colbert/colbert_3.jpg', '../../assets/tana/colbert/hotel_colbert_tana_logo.jpg'),
    ('Antananarivo', 'louvre', 1, '../../assets/tana/louvre/louvre_2.jpg', '../../assets/tana/louvre/louvre_3.jpg', '../../assets/tana/louvre/hotel_leLouvre_tana_logo.png'),
    ('Antananarivo', 'radisson', 1, '../../assets/tana/radisson/radisson_2.jpg', '../../assets/tana/radisson/radisson_3.jpg', '../../assets/tana/radisson/hotel_radisson_tana_logo.jpg'),
    ('Nosy-Be', 'anjamarango', 1, '../../assets/nosy-be/anjamarango/anjamarango_2.jpg', '../../assets/nosy-be/anjamarango/anjamarango_3.jpg', '../../assets/nosy-be/anjamarango/anjamarango_hotel_logo.png'),
    ('Nosy-Be', 'palm-beach', 1, '../../assets/nosy-be/palm-beach/palm_beach_1.jpg', '../../assets/nosy-be/palm-beach/palm_beach_2.jpg', '../../assets/nosy-be/palm-beach/palm-beach-resort-Spa_logo.jpg'),
    ('Nosy-Be','vanilla', 1, '../../assets/nosy-be/vanilla/vanila_hotel_2.jpg', '../../assets/nosy-be/vanilla/vanila-hotel-spa.jpg', '../../assets/nosy-be/vanilla/vanila_hotel_nosy_be.jpg'),
    ('Majunga','baobab', 1, '../../assets/majunga/baobab/baobab_3.jpg', '../../assets/majunga/baobab/baobab_2.jpg', '../../assets/majunga/baobab/baobab_logo.jpg'),
    ('Majunga','pap', 1, '../../assets/majunga/pap/pap_3.jpg', '../../assets/majunga/pap/paps_2.jpg', '../../assets/majunga/pap/pap_hotes_logo.jpg');
