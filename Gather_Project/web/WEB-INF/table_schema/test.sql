			SELECT rn
			FROM(SELECT ROWNUM rn, A.*
			FROM(SELECT M_IDX, T_IDX
			FROM MY_T WHERE M_IDX=1
			ORDER BY T_IDX DESC
			) A)
			WHERE T_IDX = (SELECT T_IDX FROM L_TEAM WHERE M_IDX=1)
			/*where절이 필요한 이유 : 마지막에 수정했던 tIDx값을 통해 팀 리스트의 rn을 뽑기 위해서*/
			/*rn을 뽑는 이유 : tIdx에 부합하는 rn을 통해 tIdx의 정보를 가져오기 위해*/
			
			
			SELECT ROWNUM rn, A.*
			FROM(SELECT M_IDX AS MIDX, MY_T.T_IDX AS TIDX, T_NAME AS TNAME
			FROM MY_T, TEAM WHERE MY_T.T_IDX=TEAM.T_IDX AND M_IDX=1
			ORDER BY TIDX DESC
			) A
			/*조인하는 이유 : midx로 tIdx와 tname을 받아오기 위해서*/
			/*rn이 필요한 이유 : 리스트에 넣었을 때 그 순서를 알기 위해서 (get(rn-1).tIdx)=rn이 가르키는 tIdx*/
			
			SELECT T_IDX, t_Name
			FROM Team WHERE t_IDX=(SELECT T_IDX FROM L_TEAM WHERE M_IDX=1)
			
			
			select count(*)
			from MY_T where t_idx=1;
			
			select * from work;
			
			SELECT COUNT(*) FROM MY_T WHERE m_idx=1
			
			