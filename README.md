docker run -d -p 3306:3306 \
--name soa_int_logging \
--env MYSQL_ROOT_PASSWORD='root' \
--env MYSQL_DATABASE='soa_int_logging' \
--env MYSQL_USER='soaint' \
--env MYSQL_PASSWORD='soaint' \
mysql:5.7.31