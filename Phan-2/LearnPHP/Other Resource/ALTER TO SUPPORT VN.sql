ALTER TABLE `furniture`
CHANGE `name` `name` VARCHAR(200) CHARACTER SET utf8 COLLATE utf8_vietnamese_ci NOT NULL;

ALTER TABLE `furniture` CHANGE `detail` `detail` VARCHAR(1000) CHARACTER SET utf8 COLLATE utf8_vietnamese_ci NOT NULL;