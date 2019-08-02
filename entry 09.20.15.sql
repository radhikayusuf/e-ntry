CREATE DATABASE db_entry;

USE db_entry;


CREATE TABLE tb_user(
    id_user INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    nama_user VARCHAR(60) NOT NULL, 
    no_telp VARCHAR(15) NOT NULL);

CREATE TABLE tb_kasir(
    id_kasir INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    username VARCHAR(20) NOT NULL, 
    password VARCHAR(32) NOT NULL, 
    id_user INT(11) NOT NULL, 
    CONSTRAINT `tb_kasir_id_user` FOREIGN KEY (`id_user`) REFERENCES `tb_user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE);


CREATE TABLE tb_transaksi(
    id_transaksi INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    total_cost INT(20) NOT NULL, 
    jenis_paket ENUM('CLASSIC', 'MINIMALIS', 'GOLD', 'PLATINUM') NOT NULL,
    id_user INT(11) NOT NULL, 
    id_kasir INT(11) NOT NULL,     
    CONSTRAINT `tb_transaksi_id_kasir` FOREIGN KEY (`id_kasir`) REFERENCES `tb_kasir` (`id_kasir`) ON DELETE CASCADE ON UPDATE CASCADE, 
    CONSTRAINT `tb_transaksi_id_user` FOREIGN KEY (`id_user`) REFERENCES `tb_user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE);


CREATE TABLE tb_photographer(
    id_photographer INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    username VARCHAR(20) NOT NULL, 
    password VARCHAR(32) NOT NULL, 
    id_user INT(11) NOT NULL, 
    CONSTRAINT `tb_photographer_id_user` FOREIGN KEY (`id_user`) REFERENCES `tb_user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE tb_studio(
    id_studio INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    nama_studio VARCHAR(20) NOT NULL, 
    id_photographer INT(11),
    CONSTRAINT `tb_studio_id_photographer` FOREIGN KEY (`id_photographer`) REFERENCES `tb_photographer` (`id_photographer`) ON DELETE CASCADE ON UPDATE CASCADE);
    

CREATE TABLE tb_antrian(
    id_antrian INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    no_antrian INT(5) NOT NULL, 
    durasi int(15) NOT NULL, 
    waktu_mulai TIMESTAMP, 
    waktu_selesai TIMESTAMP, 
    jumlah_orang INT(3) NOT NULL DEFAULT 1, 
    id_transaksi INT(11) NOT NULL,  
    id_studio int(11),
    is_done int(1) DEFAULT 0,
    CONSTRAINT `tb_antrian_id_transaksi` FOREIGN KEY (`id_transaksi`) REFERENCES `tb_transaksi` (`id_transaksi`) ON DELETE CASCADE ON UPDATE CASCADE, 
    CONSTRAINT `tb_antrian_id_studio` FOREIGN KEY (`id_studio`) REFERENCES `tb_studio` (`id_studio`) ON DELETE CASCADE ON UPDATE CASCADE);


INSERT INTO tb_user(`id_user`, `nama_user`, `no_telp`) VALUES(11001, 'Radhika Yusuf Alifiansyah', '081222445115');
INSERT INTO tb_user(`id_user`, `nama_user`, `no_telp`) VALUES(11002, 'Yongki Agustin', '081222445117');
INSERT INTO tb_user(`id_user`, `nama_user`, `no_telp`) VALUES(11003, 'Ricky Yudha', '081222445116');
INSERT INTO tb_user(`id_user`, `nama_user`, `no_telp`) VALUES(11004, 'Siti Safira Nadifa', '081222445118');
INSERT INTO tb_user(`id_user`, `nama_user`, `no_telp`) VALUES(11005, 'Gugun Anthoni', '081222445119');
INSERT INTO tb_user(`id_user`, `nama_user`, `no_telp`) VALUES(11006, 'Budi Pramata', '081222445119');
INSERT INTO tb_user(`id_user`, `nama_user`, `no_telp`) VALUES(11007, 'Yusuf Kurniawan', '081222445119');

INSERT INTO tb_kasir(`id_kasir`, `username`, `password`, `id_user`) VALUES(11101, 'radhikayusuf', md5('qwerty123'), 11001);
INSERT INTO tb_kasir(`id_kasir`, `username`, `password`, `id_user`) VALUES(11102, 'yongkiagustin', md5('qwerty123'), 11002);

INSERT INTO tb_photographer(`id_photographer`,`username`,`password`, `id_user`) VALUES(10001, 'gugun', md5('qwerty123'), 11005);
INSERT INTO tb_photographer(`id_photographer`,`username`,`password`, `id_user`) VALUES(10002, 'budibudi', md5('qwerty123'), 11006);
INSERT INTO tb_photographer(`id_photographer`,`username`,`password`, `id_user`) VALUES(10003, 'yusufyusuf', md5('qwerty123'), 11007);

INSERT INTO tb_studio(`id_studio`, `nama_studio`,`id_photographer`) VALUES(10011, 'Studio 1', 10001);
INSERT INTO tb_studio(`id_studio`, `nama_studio`,`id_photographer`) VALUES(10012, 'Studio 2', 10002);
INSERT INTO tb_studio(`id_studio`, `nama_studio`,`id_photographer`) VALUES(10013, 'Studio 3', 10003);
INSERT INTO tb_studio(`id_studio`, `nama_studio`,`id_photographer`) VALUES(10014, 'Studio 4', NULL);
INSERT INTO tb_studio(`id_studio`, `nama_studio`,`id_photographer`) VALUES(10015, 'Studio 5', NULL);

INSERT INTO tb_transaksi(`id_transaksi`, `total_cost`, `jenis_paket`, `id_user`, `id_kasir`) VALUES(10111, 60000, 'CLASSIC', 11003, 11101);
INSERT INTO tb_transaksi(`id_transaksi`, `total_cost`, `jenis_paket`, `id_user`, `id_kasir`) VALUES(10112, 240000, 'PLATINUM', 11002, 11102);

INSERT INTO tb_antrian(`id_antrian`, `no_antrian`, `durasi`, `waktu_mulai`, `waktu_selesai`, `jumlah_orang`, `id_transaksi`, `id_studio`) VALUES(11111, 1, 1800, null, null, 4, 10111, 10012);
INSERT INTO tb_antrian(`id_antrian`, `no_antrian`, `durasi`, `waktu_mulai`, `waktu_selesai`, `jumlah_orang`, `id_transaksi`, `id_studio`) VALUES(11112, 2, 1800, null, null, 4, 10112, 10011);




SET @username = 'radhikayusuf';
SET @password = md5('qwerty123');

SELECT * FROM tb_kasir WHERE `username` = @username AND `password` = @password;


SELECT 
    tb_user.nama_user as `Nama Konsumen`, 
    tb_transaksi.jenis_paket as `Jenis Paket`, 
    tb_user.no_telp as `No Telpon`, 
    tb_antrian.jumlah_orang as `Jumlah Orang`,
    tb_antrian.no_antrian as `No Antrian`,
    tb_studio.nama_studio as `Studio` 
FROM tb_transaksi
INNER JOIN tb_user ON tb_transaksi.id_user = tb_user.id_user
INNER JOIN tb_antrian ON tb_transaksi.id_transaksi = tb_antrian.id_transaksi
INNER JOIN tb_studio ON tb_antrian.id_studio = tb_studio.id_studio;


SELECT 
    `tb_studio`.`nama_studio` as `Nama Studio`,
    `tb_antrian`.`no_antrian` as `Nomor Antrian`,
    `tb_transaksi`.`jenis_paket` as `Jenis Paket`    
FROM tb_antrian 
INNER JOIN tb_studio ON tb_antrian.id_studio = tb_studio.id_studio
INNER JOIN tb_transaksi ON tb_transaksi.id_transaksi = tb_antrian.id_transaksi
WHERE tb_studio.id_studio = 10012
AND tb_antrian.is_done = 0
ORDER BY tb_antrian.id_antrian DESC LIMIT 1;


SELECT `nama_studio` as `Nama Studio`FROM tb_studio WHERE id_photographer IS NOT NULL;

SELECT 
    `nama_studio` as `Nomor Studio`,
    `no_antrian` as `Nomor Antrian`
FROM tb_antrian 
INNER JOIN tb_studio ON tb_antrian.id_studio = tb_studio.id_studio
WHERE tb_antrian.is_done = 0
ORDER BY tb_studio.id_studio;



DELIMITER //

CREATE FUNCTION getPrice (paket_option VARCHAR(20)) RETURNS INT(50) 
 DETERMINISTIC 
 BEGIN
     IF (paket_option = 'CLASSIC') THEN
         RETURN 60000;
     END IF;
     IF paket_option = 'MINIMALIS' THEN
         RETURN 120000;
     END IF;
     IF paket_option = 'GOLD' THEN
         RETURN 180000;
     END IF;
     IF paket_option = 'PLATINUM' THEN
         RETURN 240000;
     END IF;
 END //

 CREATE PROCEDURE createTransaction (IN nama VARCHAR(60), IN noTelp VARCHAR(20), IN jenis_paket VARCHAR(10), IN id_studio INT(11), IN id_kasir INT(11), IN jumlah_orang INT(3))
 BEGIN
    SET @id_user = 0;
    SET @latest_antrian = 0;
    SET @id_transaksi = 0;

    INSERT INTO tb_user(nama_user, no_telp) VALUES(nama, noTelp);

    SELECT `id_user` INTO @id_user FROM tb_user WHERE `nama_user` = nama AND `no_telp` = noTelp ORDER BY `id_user` DESC LIMIT 1;
    INSERT INTO tb_transaksi(total_cost, jenis_paket, id_user, id_kasir) VALUES(getPrice(jenis_paket), jenis_paket, @id_user, id_kasir);

    SELECT `no_antrian` INTO @latest_antrian FROM tb_antrian ORDER BY `id_antrian` DESC LIMIT 1;
    SELECT `id_transaksi` INTO @id_transaksi FROM tb_transaksi ORDER BY `id_transaksi` DESC LIMIT 1;

    SET @latest_antrian = @latest_antrian + 1;
    INSERT INTO tb_antrian(no_antrian, durasi, waktu_mulai, waktu_selesai, jumlah_orang, id_transaksi, id_studio) VALUES(@latest_antrian, 0, null, null, jumlah_orang, @id_transaksi, id_studio);     
 END //


 CREATE PROCEDURE searchInTransaction (IN search VARCHAR(60))
 BEGIN
 
    SELECT 
        tb_transaksi.id_transaksi as `ID`, 
        tb_user.nama_user as `Nama Konsumen`, 
        tb_transaksi.jenis_paket as `Jenis Paket`, 
        tb_user.no_telp as `No Telpon`, 
        tb_antrian.jumlah_orang as `Jumlah Orang`,
        tb_antrian.no_antrian as `No Antrian`,
        tb_studio.nama_studio as `Studio` 
    FROM tb_transaksi
    INNER JOIN tb_user ON tb_transaksi.id_user = tb_user.id_user
    INNER JOIN tb_antrian ON tb_transaksi.id_transaksi = tb_antrian.id_transaksi
    INNER JOIN tb_studio ON tb_antrian.id_studio = tb_studio.id_studio
    WHERE 
        tb_user.nama_user LIKE search OR 
        tb_transaksi.jenis_paket LIKE search OR
        tb_user.no_telp LIKE search OR
        tb_antrian.jumlah_orang LIKE search OR
        tb_antrian.no_antrian LIKE search OR
        tb_studio.nama_studio LIKE search;
 END //



 CREATE PROCEDURE updateTransaction (IN pid_transaksi INT(11), IN nama VARCHAR(60), IN noTelp VARCHAR(20), IN pjenis_paket VARCHAR(10), IN pid_studio INT(11), IN id_kasir INT(11), IN pjumlah_orang INT(3))
 BEGIN
    SET @id_user = 0;
    SET @id_antrian = 0;
    
    
    SELECT `id_user` INTO @id_user FROM tb_transaksi WHERE `id_transaksi` = pid_transaksi ORDER BY `id_transaksi` DESC LIMIT 1;
    SELECT `id_antrian` INTO @id_antrian FROM tb_antrian WHERE `id_transaksi` = pid_transaksi ORDER BY `id_antrian` DESC LIMIT 1;
    
    UPDATE tb_user SET nama_user = nama, no_telp = noTelp WHERE id_user = @id_user;
    UPDATE tb_transaksi SET total_cost = getPrice(pjenis_paket), jenis_paket = pjenis_paket WHERE id_transaksi = pid_transaksi;
    UPDATE tb_antrian SET jumlah_orang = pjumlah_orang, id_studio = pid_studio WHERE id_antrian = @id_antrian;


 END //


CREATE PROCEDURE listQueueByStudio (IN pid_studio INT(11), IN lastestId INT(11), IN searchParam VARCHAR(60))
 BEGIN
    SELECT 
        `tb_studio`.`nama_studio` as `Nama Studio`,
        `tb_user`.`nama_user` as `Nama Customer`,
        `tb_antrian`.`no_antrian` as `Nomor Antrian`,
        `tb_transaksi`.`jenis_paket` as `Jenis Paket`    
    FROM tb_antrian 
    INNER JOIN tb_studio ON tb_antrian.id_studio = tb_studio.id_studio
    INNER JOIN tb_transaksi ON tb_transaksi.id_transaksi = tb_antrian.id_transaksi
    INNER JOIN tb_user ON tb_transaksi.id_user = tb_user.id_user
    WHERE tb_studio.id_studio = pid_studio AND
    tb_antrian.id_antrian != lastestId AND
    tb_antrian.is_done = 0 AND 
    (`tb_studio`.`nama_studio` LIKE searchParam OR
    `tb_user`.`nama_user` LIKE searchParam OR
    `tb_antrian`.`no_antrian` LIKE searchParam OR
    `tb_transaksi`.`jenis_paket` LIKE searchParam)
    ORDER BY tb_antrian.id_antrian ASC;

END //


CREATE PROCEDURE startQueue(IN pid_antrian INT(11))
BEGIN

    UPDATE tb_antrian SET waktu_mulai = now() WHERE id_antrian = pid_antrian;
END//

CREATE PROCEDURE endQueue(IN pid_antrian INT(11))
BEGIN

    UPDATE tb_antrian SET waktu_selesai = now(), is_done = 1 WHERE id_antrian = pid_antrian;
END//

DELIMITER ;


CALL createTransaction('Irfan Zaelani', '0837328179231', 'GOLD', 10012, 11102, 5);
CALL updateTransaction(10113, 'Irfan Zaelani', '081222556116', 'GOLD', 10012, 11102, 4);
CALL searchInTransaction('%irf%');

