-- 천재지변으로 인해 일부 데이터가 유실되었습니다. 입양을 간 기록은 있는데, 
-- 보호소에 들어온 기록이 없는 동물의 ID와 이름을 ID 순으로 조회하는 SQL문을 작성해주세요.

-- 제출
select O.ANIMAL_ID, O.NAME
from ANIMAL_INS I right join ANIMAL_OUTS O using (ANIMAL_ID)
where I.NAME is null and O.NAME is not null
order by 1;
