delete from users where id is not null;
delete from estates where id is not null;
delete from events where id is not null;

-- USERS
insert into users(id, email, version)
values ('0d3a68a1-5919-4914-bc20-839fae2480ac', 'admin@tut.by', 1),
       ('1d3a68a1-5919-4914-bc20-839fae2480ac', 'seller@tut.by', 1),
       ('2d3a68a1-5919-4914-bc20-839fae2480ac', 'consumer@tut.by', 1);

-- ESTATES
insert into estates(id, apartment, location, area, description, file_name)
values ('1413a291-b991-4b92-98aa-0c9a0a810208', false, 'Minsk region', 1500,
        'Thoughtful architectural layout, 5-room, ceiling height 3.76 meters, all construction work was carried out ' ||
        'according to design drawings, in strict accordance with technological processes and knowledge of the latest ' ||
        'trends in modern suburban construction; Residential modern cottage development, respectable neighbors; ' ||
        'All communications: electricity, gas, central water supply, sewerage, optical fiber, wiring for video ' ||
        'surveillance, mobile internet, video intercom',
        '11111111-b991-4b92-98aa-0c9a0a810277.png'),
       ('2413a291-b991-4b92-98aa-0c9a0a810208', false, 'Minsk city', 1400,
        'Cottage for sale in a premium building district of the National Library. One of a kind, the house was built on ' ||
        'an individual project and combines the airiness and functionality of structures made from environmentally ' ||
        'friendly natural materials. Laconic sophisticated design. The level of finish - perfection in the details! ' ||
        'Energy-saving technologies, equipment and materials were used.',
        '21111111-b991-4b92-98aa-0c9a0a810277.png'),
       ('3413a291-b991-4b92-98aa-0c9a0a810208', false, 'Minsk region', 1227,
        'Cottage for sale in the city of Zaslavl. The decoration used high-quality materials. The total area of the ' ||
        'house - 270 sq.m, living area - 77 sq.m 2 floors plus basement (block, brick). 6 living rooms, 2 bathrooms, ' ||
        'veranda, balcony. The house is fully equipped with household appliances and furniture. There is a fireplace, ' ||
        'washing machine and dishwasher. Good road and stable cellular connection.',
        '31111111-b991-4b92-98aa-0c9a0a810277.png'),
       ('4413a291-b991-4b92-98aa-0c9a0a810208', false, 'Minsk region', 2000,
        'There is a complete architectural project and a structural solution, plus a design project with the arrangement ' ||
        'of rooms, furniture arrangement, electrical and plumbing layout, developed individually by our architects, ' ||
        'constructors and designers! A complete design project is available for you! All works were completed according ' ||
        'to the project, each stage of construction was accepted and recorded by the architect, there are photos and ' ||
        'videos of all stages of construction!',
        '41111111-b991-4b92-98aa-0c9a0a810277.png'),
       ('5413a291-b991-4b92-98aa-0c9a0a810208', false, 'Minsk region', 1100,
        'If you care about your health and think about a long life, then this house is for you. The house is made of ' ||
        'Arkhangelsk pine 32 diameter winter competent manual felling. For final finishing, three-chamber double-glazed ' ||
        'windows made of larch with argon, walls are painted, there is insulation of the roof and interior ceilings, ' ||
        'a rich forged staircase. On the site there is an outdoor swimming pool with a water purification and filtration ' ||
        'system. An ideal well-groomed lawn. Blueberries, blueberries, honeysuckle, peaches, etc. bear fruit.',
        '51111111-b991-4b92-98aa-0c9a0a810277.png'),
       ('6413a291-b991-4b92-98aa-0c9a0a810208', true, 'Minsk city', 29.4,
        'The apartment is unfurnished, which opens up the prospect for new owners to do everything according to their ' ||
        'taste and capabilities. The panoramic view from the windows of the 20th floor allows you to fully enjoy the ' ||
        'beauty of architecture and the lights of the city at night. The lower part of the continuous glazing cannot be ' ||
        'opened and is equipped with reinforced unbreakable double-glazed windows. The ceiling height is 2.73 m, which ' ||
        'adds volume and light.',
        '61111111-b991-4b92-98aa-0c9a0a810277.png'),
       ('7413a291-b991-4b92-98aa-0c9a0a810208', true, 'Minsk city', 22.27,
        'Brick house. Installed metal front door, MDF interior doors. All windows are glazed with double-glazed windows ' ||
        'with PVC profile. Flooring - laminate, tiles in the kitchen. Wardrobe in the hallway. The bathroom is combined. ' ||
        'Water and gas meters connected. Intercom, fiber optic communication. The house is located in a residential area ' ||
        'with established infrastructure. Near kindergartens, gymnasiums and schools, shops, supermarkets, medical, sports, ' ||
        'shopping and business centers, service and leisure facilities.',
        '71111111-b991-4b92-98aa-0c9a0a810277.png'),
       ('8413a291-b991-4b92-98aa-0c9a0a810208', true, 'Minsk city', 34.4,
        'The apartment is located on the sixth floor of a nine-story building built in 1987. Good layout. The entrance ' ||
        'door is double. The window openings are equipped with double-glazed windows with a PVC profile. Floor ' ||
        'covering - linoleum. Kitchen set in the kitchen. The bathroom is tiled, water meters are installed. A fiber ' ||
        'optic network has been installed. The elevator has been replaced. Developed infrastructure of the area. ' ||
        'Within walking distance from the house there is a kindergarten No. 507, a comprehensive school No. 172. ' ||
        'A clinic, dentistry, bank branches, a post office, a pharmacy, a supermarket. Not far from the house there is ' ||
        'a bath-health complex. The facility is located ten minutes by public transport to the Mogilevskaya metro station. ' ||
        'Convenient access to the Moscow Ring Road.',
        '81111111-b991-4b92-98aa-0c9a0a810277.png'),
       ('9413a291-b991-4b92-98aa-0c9a0a810208', true, 'Minsk city', 33,
        'Apartment in Malinovka. Ready to move in. Developed infrastructure, kindergartens, schools, Malinovka bath and ' ||
        'recreation complex, many shops and shopping centers for leisure and recreation. Pavlov park within walking distance. ' ||
        'Malinovka metro station two stops, as well as a large selection of ground transport to different parts of the city.',
        '91111111-b991-4b92-98aa-0c9a0a810277.png'),
       ('1013a291-b991-4b92-98aa-0c9a0a810208', true, 'Minsk region', 33.72,
        'There is a landscaped area around the house, which includes a playground, bicycle parking, parking for 200 cars ' ||
        'for residents of the house. All the necessary infrastructure has been created around the house: kindergartens, ' ||
        'nurseries, a school, a gymnasium, a clinic, several pharmacies, and gyms. Stores: Euroopt, Hit, Kopeechka, ' ||
        'Dobronom, Island of Purity',
        '10111111-b991-4b92-98aa-0c9a0a810277.png');