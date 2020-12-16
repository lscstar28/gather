package com.mainDP.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gather.entity.DesignDTO;
import com.gather.entity.TeamDTO;
import com.gather.entity.WorkDTO;

@Repository("mainDPDAO")
public class MainDPDAO {
	@Autowired
	private SqlSessionFactory factory;

	public List<TeamDTO> listTeam(int mIdx) {
		System.out.println("dao listTeam : " + mIdx);
		SqlSession session = factory.openSession();
		List<TeamDTO> list = null;
		synchronized (factory) {
			try {
				list = factory.openSession().selectList("my.gather-mapping.listTeam", mIdx);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
		return list;
	}

	public List<String> TeamMember(int lastTIdx) {
		System.out.println("dao teamMember : " + lastTIdx);
		SqlSession session = factory.openSession();
		List<String> list = null;
		synchronized (factory) {
			try {
				list = session.selectList("my.gather-mapping.teamMember", lastTIdx);
			} catch (Exception e) {
			} finally {
				synchronized (factory) {
					session.close();
				}
			}
		}
		return list;
	}

	public DesignDTO getDesign(int tIdx) {
		System.out.println("dao getDesign : " + tIdx);
		SqlSession session = factory.openSession();
		DesignDTO dto = null;
		synchronized (factory) {
			try {
				dto = session.selectOne("my.gather-mapping.getDesign", tIdx);
			} catch (Exception e) {
			} finally {
				synchronized (factory) {
					session.close();
				}
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
			} finally {
				synchronized (factory) {
					session.close();
				}
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
			} finally {
				synchronized (factory) {
					session.close();
				}
			}
		}
		return list;
	}

	public List<WorkDTO> workList(int tIdx) {
		SqlSession session = factory.openSession();
		List<WorkDTO> list = null;
		synchronized (factory) {
			try {
				list = session.selectList("my.gather-mapping.getWorkList", tIdx);
			} catch (Exception e) {
			} finally {

				session.close();

			}
		}
		return list;
	}

	public List<String> CallMember(int tIdx) {
		SqlSession session = factory.openSession();
		List<String> list = null;
		synchronized (factory) {
			try {
				list = session.selectList("my.gather-mapping.getCallMember", tIdx);
			} catch (Exception e) {
			} finally {
				synchronized (factory) {
					session.close();
				}
			}
		}
		return list;
	}

	public int getRn(int mIdx) {
		SqlSession session = factory.openSession();
		int n = 0;
		synchronized (factory) {
			try {
				n = session.selectOne("my.gather-mapping.getRn", mIdx);
			} catch (Exception e) {
			} finally {
				synchronized (factory) {
					session.close();
				}
			}
		}
		return n;
	}

	public int LastTeam(Map<String, Integer> mt) {
		SqlSession session = factory.openSession();
		int n = 0;
		synchronized (factory) {
			try {
				n = session.update("my.gather-mapping.LastTeam", mt);
			} catch (Exception e) {
			} finally {
				synchronized (factory) {
					session.close();
				}
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
			} finally {
				synchronized (factory) {
					session.close();
				}
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
				synchronized (factory) {
					session.close();
				}
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
			} finally {
				synchronized (factory) {
					session.close();
				}
			}
		}
		return n;
	}

}
