# -- 코드를 입력하세요
# SELECT USER_ID, NICKNAME, 
# CONCAT(CITY, " ", STREET_ADDRESS1, " ", STREET_ADDRESS2) AS '전체주소', 
# CONCAT(LEFT(TLNO, 3), "-", MID(TLNO, 4, 4), "-", RIGHT(TLNO, 3)) AS '전화번호'
# FROM USED_GOODS_USER U JOIN USED_GOODS_BOARD B ON U.USER_ID = B.WRITER_ID
# GROUP BY B.WRITER_ID
# HAVING COUNT(B.WRITER_ID) >= 3
# ORDER BY USER_ID DESC;

SELECT B.user_id,B.nickname
,concat(B.city,' ',B.street_address1,' ',B.street_address2) AS 전체주소
,concat(LEFT(tlno,3), '-', MID(tlno,4,4),'-', RIGHT(tlno,4)) AS 전화번호
FROM used_goods_board A join used_goods_user B ON A.writer_id = B.user_id
GROUP BY writer_id
HAVING count(writer_id) >= 3
ORDER BY B.user_id DESC