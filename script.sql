USE `web_customer_tracker`;

#
# Table structure for `users`
#
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar (50) NOT NULL,
  `password` char (68) NOT NULL,
  `enabled` tinyint (1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


#
# Inserting data for table `users`
# non-hashed passwords.
#
INSERT INTO `users`
VALUES
  ('john', '{bcrypt}$2a$04$1pxXKQi1IBkZ4icMVMO5GeMONQLzLwSsS75OJKKzyfNNiXh2CLspu', 1),
  ('mary', '{bcrypt}$2a$04$BlBCLuEQKfVXoTi8w4Z8rudwDeacry.qzOCq7ZX0f37xwBLsooRxq', 1),
  ('suzanne', '{bcrypt}$2a$04$JugNriszFTVqhTxld5LEee.5OW6C4r2TQode79Wb1V8WkBvVQZS.S', 1);




DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar (50) NOT NULL,
  `authority` varchar (50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`, `authority`),
  CONSTRAINT `authorities_ibfk_1`
  FOREIGN KEY (`username`)
  REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



#
# Inserting data for table `authorities`
#
INSERT INTO `authorities`
VALUES
  ('john', 'ROLE_EMPLOYEE'),
  ('mary', 'ROLE_EMPLOYEE'),
  ('mary', 'ROLE_MANAGER'),
  ('suzanne', 'ROLE_EMPLOYEE'),
  ('suzanne', 'ROLE_MANAGER'),
  ('suzanne', 'ROLE_ADMIN');