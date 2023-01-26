--INSERT INTO users (id, username, password, first_name, last_name, is_active, image_url)
--VALUES (1, 'ivan@abv.bg', 'somepass', 'Ivan', 'Ivanov', 1 , 'resources/static/img/1.jpg') ;
--
--INSERT INTO users (id, username, password, first_name, last_name, is_active, image_url)
--VALUES (2, 'Peter@abv.bg', 'somepass2', 'Peter', 'Petrov', 1 , 'resources/static/img/1.jpg') ;
--
--INSERT INTO brands (id, name)
--VALUES (1, 'BMW'),(2, 'Opel');

--
--INSERT INTO models (name, category, start_year, end_year, image_url, brand_id)
--VALUES ("Z4", 'CAR', 2002, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/2011_BMW_Z4_sDrive23i_M_Sport_Highline_2.5.jpg/560px-2011_BMW_Z4_sDrive23i_M_Sport_Highline_2.5.jpg", 1),
--("X3", 'CAR', 2003, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/8/85/2018_BMW_X3_xDrive20d_SE_Automatic_2.0_Front.jpg/560px-2018_BMW_X3_xDrive20d_SE_Automatic_2.0_Front.jpg", 1),
--("X5", 'CAR', 1999, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f1/2019_BMW_X5_M50d_Automatic_3.0.jpg/560px-2019_BMW_X5_M50d_Automatic_3.0.jpg",1),
--("X6", 'CAR', 2007, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cd/2020_BMW_X6_xDrive30d_M_Sport_Automatic_3.0.jpg/560px-2020_BMW_X6_xDrive30d_M_Sport_Automatic_3.0.jpg",1),
--("G30", 'CAR', 2016, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bf/2018_BMW_520d_M_Sport_Automatic_2.0_%281%29.jpg/560px-2018_BMW_520d_M_Sport_Automatic_2.0_%281%29.jpg",1),
--("Z8", 'CAR', 2000, 2003, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/BMW_Z8_%282009-05-20%29.JPG/560px-BMW_Z8_%282009-05-20%29.JPG",1),
--("R1200GS", 'MOTORCYCLE', 2004, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/7/79/BMW_R1200GS_July_2010.jpg/1024px-BMW_R1200GS_July_2010.jpg",1),
--("G32", 'CAR', 2017, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/2018_BMW_630d_GT_M_Sport_Automatic_3.0_Front.jpg/560px-2018_BMW_630d_GT_M_Sport_Automatic_3.0_Front.jpg",1),
--("K1600", 'MOTORCYCLE', 2001, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f5/K1600_Seite.jpg/600px-K1600_Seite.jpg",1),
--("M4", 'CAR', 2014, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/2015_BMW_M4_%28F82%29_coupe_%2824220553394%29.jpg/560px-2015_BMW_M4_%28F82%29_coupe_%2824220553394%29.jpg",1),
--
--("Astra J", 'CAR', 2009, 2015,"https://upload.wikimedia.org/wikipedia/commons/thumb/e/e0/Opel_Astra_J.JPG/300px-Opel_Astra_J.JPG",2),
--("Ampera", 'CAR', 2011, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/Opel_Ampera_%E2%80%93_Frontansicht%2C_18._Juni_2012%2C_D%C3%BCsseldorf.jpg/300px-Opel_Ampera_%E2%80%93_Frontansicht%2C_18._Juni_2012%2C_D%C3%BCsseldorf.jpg",2),
--("Insignia A", 'CAR', 2008, 2017, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c4/Opel_Insignia_20090717_front.jpg/300px-Opel_Insignia_20090717_front.jpg",2),
--("Zafira Tourer C", 'CAR', 2011, 2019, "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9f/Opel_Zafira_C_2016_facelift_at_Schaffen_Diest_%282017%29.jpg/300px-Opel_Zafira_C_2016_facelift_at_Schaffen_Diest_%282017%29.jpg",2),
--("Vivaro A", 'BUS', 2001, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/8/85/Opel_Vivaro_front_20080108.jpg/300px-Opel_Vivaro_front_20080108.jpg",2),
--("Movano B", 'BUS', 2010, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6c/Opel_Movano_B_front_20100705.jpg/300px-Opel_Movano_B_front_20100705.jpg",2),
--("Blitz", 'TRUCK', 1966, 1975, "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Opel_blitz_3_sst.jpg/300px-Opel_blitz_3_sst.jpg",2)
--;

INSERT INTO offers(id, engine, image_Url, mileage, price, transmission, year, seller_id, model_id)
VALUES(1,'DIESEL', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/2015_BMW_M4_%28F82%29_coupe_%2824220553394%29.jpg/560px-2015_BMW_M4_%28F82%29_coupe_%2824220553394%29.jpg', 140000, 35000, 'AUTOMATIC', 2012, 1, 1);