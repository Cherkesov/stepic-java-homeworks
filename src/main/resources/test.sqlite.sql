CREATE TABLE IF NOT EXISTS `user`
(
  `id`       INTEGER PRIMARY KEY AUTOINCREMENT,
  `login`    VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL
);
CREATE UNIQUE INDEX `user_login_uindex`
  ON `user` (login);