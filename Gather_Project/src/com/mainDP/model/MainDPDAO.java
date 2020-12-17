package com.mainDP.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gather.entity.DesignDTOR;
import com.gather.entity.TeamDTO;
import com.gather.entity.WorkDTO;
import com.gather.entity.WorkDTOR;

@Repository("mainDPDAO")
public class MainDPDAO {
	@Autowired
	private SqlSessionFactory factory;

	// ========== 팀 리스트 불러오기 ==========
	public List<TeamDTO> listTeam(int mIdx) {
		SqlSession session = factory.openSession();
		List<TeamDTO> list = null;
		synchronized (factory) {
			try {
				list = factory.openSession().selectList("my.gather-mapping.getListTeam", mIdx);
			} catch (NullPointerException e) {
				list = null;
				System.out.println("팀 리스트가 비어있습니다.");
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				session.close();
			}
		}
		return list;
	}
	
	// ========== 마지막에 수정했던 팀의 tIdx, tName 가져오기 ==========
	public TeamDTO getSelectTeam(int mIdx) {
		SqlSession session = factory.openSession();
		TeamDTO dto = null;
		synchronized (factory) {
			try {
				dto = session.selectOne("my.gather-mapping.getSelectTeam", mIdx);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
		return dto;
	}

	// ========== 팀에 소속된 맴버 리스트 가져오기 ==========	
	public List<String> TeamMember(int lastTIdx) {
		SqlSession session = factory.openSession();
		List<String> list = null;
		synchronized (factory) {
			try {
				list = session.selectList("my.gather-mapping.getTeamMember", lastTIdx);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
		return list;
	}

	// ========== 초대 요청 중인 맴버 리스트 가져오기 ==========	
	public List<String> CallMember(int tIdx) {
		SqlSession session = factory.openSession();
		List<String> list = null;
		synchronized (factory) {
			try {
				list = session.selectList("my.gather-mapping.getCallMember", tIdx);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
					session.close();
			}
		}
		return list;
	}

	// ========== 팀 기획 정보(기획 번호, 기획 주제) 가져오기 ==========	
	public DesignDTOR getDesign(int tIdx) {
		System.out.println("dao getDesign : " + tIdx);
		SqlSession session = factory.openSession();
		DesignDTOR dto = null;
		synchronized (factory) {
			try {
				dto = session.selectOne("my.gather-mapping.getDesign", tIdx);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
					session.close();
			}
		}
		return dto;
	}

	public List<String> designPurpose(int dIdx) {
		System.out.println("dao getdesignPurpose : " + dIdx);
		SqlSession session = factory.openSession();
		List<String> list = null;
		synchronized (factory) {
			try {
				list = session.selectList("my.gather-mapping.getdesignPurpose", dIdx);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
session.close();
			}
		}
		return list;
	}

	public List<String> designContent(int dIdx) {
		System.out.println("dao getdesignContent : " + dIdx);
		SqlSession session = factory.openSession();
		List<String> list = null;
		synchronized (factory) {
			try {
				list = session.selectList("my.gather-mapping.getdesignContent", dIdx);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
					session.close();
			}
		}
		return list;
	}

	public List<WorkDTOR> workList(int tIdx) {
		SqlSession session = factory.openSession();
		List<WorkDTOR> list = null;
		synchronized (factory) {
			try {
				list = session.selectList("my.gather-mapping.getWorkList", tIdx);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
		return list;
	}


	
	public int LastTeam(Map<String, Integer> mt) {
		SqlSession session = factory.openSession();
		int n = 0;
		synchronized (factory) {
			try {
				n = session.update("my.gather-mapping.LastTeam", mt);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
					session.close();
			}
		}
		return n;
	}

	public int creLastTeam(Map<String, Integer> mt) {
		SqlSession session = factory.openSession();
		int n = 0;
		synchronized (factory) {
			try {
				n = session.insert("my.gather-mapping.creLastTeam", mt);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
					session.close();
			}
		}
		return n;
	}

	public List<TeamDTO> callConfrim(int mIdx) {
		SqlSession session = factory.openSession();
		List<TeamDTO> list = null;
		synchronized (factory) {
			try {
				list = session.selectList("my.gather-mapping.callConfrim", mIdx);
			} catch (Exception e) {
			} finally {
					session.close();
			}
		}
		return list;
	}

	public int LastTeamDel(int mIdx) {
		SqlSession session = factory.openSession();
		int n = 0;
		synchronized (factory) {
			try {
				n = session.delete("my.gather-mapping.LastTeamDel", mIdx);
			} catch (NullPointerException e) {
				n = 0;
				System.out.println("지울 팀이 없습니다.");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
					session.close();
			}
		}
		return n;
	}

}
