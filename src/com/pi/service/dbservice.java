package com.pi.service;

import com.pi.bean.*;
import com.pi.util.DB;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.pi.util.ReflectUtil;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class dbservice {

    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/XE";
    static final String USER = "pisystem";
    static final String PASS = "Lion0412";


    public List<Personal> listPersonal() {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        List<Personal> personalList = new ArrayList<Personal>();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            BeanListHandler<Personal> beanListHandler = new BeanListHandler<Personal>(Personal.class);
            personalList = queryRunner.query(conn, "SELECT * FROM PERSONAL", beanListHandler);
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return personalList;
    }

    public List<Training> listTraining() {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        List<Training> trainingList = new ArrayList<Training>();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            BeanListHandler<Training> beanListHandler = new BeanListHandler<Training>(Training.class);
            trainingList = queryRunner.query(conn, "SELECT * FROM TRAINING ", beanListHandler);
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return trainingList;
    }

    public Personal getPersonalBeanByPid(String pid) {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        Personal personalBean = new Personal();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            BeanHandler<Personal> beanHandler = new BeanHandler<Personal>(Personal.class);
            personalBean = queryRunner.query(conn, "SELECT * FROM personal where PID = " + pid, beanHandler);
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return personalBean;
    }

    public Training getTrainingBeanByTid(int tid) {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        Training TrainingBean = new Training();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            BeanHandler<Training> beanHandler = new BeanHandler<Training>(Training.class);
            TrainingBean = queryRunner.query(conn, "SELECT * FROM TRAINING where TID = " + tid, beanHandler);
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return TrainingBean;
    }

    public List<Person2training> person2trainingListByTid(int tid) {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        List<Person2training> person2trainingList = new ArrayList<Person2training>();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            BeanListHandler<Person2training> beanHandler = new BeanListHandler<Person2training>(Person2training.class);
            person2trainingList = queryRunner.query(conn, "SELECT * FROM PERSONAL2TRAINING where TID = " + tid, beanHandler);
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return person2trainingList;
    }

    public List<Car> listCarBeanByPid(String pid) {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        List<Car> carList = new ArrayList<Car>();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            BeanListHandler<Car> beanListHandler = new BeanListHandler<Car>(Car.class);
            carList = queryRunner.query(conn, "SELECT * FROM car where pid = " + pid, beanListHandler);
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return carList;
    }

    public List<Child> listChildBeanByPid(String pid) {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        List<Child> childList = new ArrayList<Child>();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            BeanListHandler<Child> beanListHandler = new BeanListHandler<Child>(Child.class);
            childList = queryRunner.query(conn, "SELECT * FROM child where pid = " + pid, beanListHandler);
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return childList;
    }

    public List<Zhizhao> listZhizhaoBeanByPid(String pid) {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        List<Zhizhao> zhizhaoList = new ArrayList<Zhizhao>();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            BeanListHandler<Zhizhao> beanListHandler = new BeanListHandler<Zhizhao>(Zhizhao.class);
            zhizhaoList = queryRunner.query(conn, "SELECT * FROM zhizhao where pid = " + pid, beanListHandler);
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return zhizhaoList;
    }

    //更新用户基本信息，不包括child，car，zhizhao
    public void updatePersonal(Personal personal) {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "UPDATE personal set XINMIN=? , SHENFENZHEN=? , SHENRI=? , XINBIE=? , BIYEYUANXIAO=? , GONGZUONIANYUE=? " +
                    ", ZHIWU=? , ZHICHEN=? , JISHUZHIWU=? , ZHENZHIMIANMAO=? , JIATINZHUZHI=? , SHOUJI=? , ZHAIDIAN=? , " +
                    "XUELI=? , JIGUAN=? where PID = '" + personal.getPID() + "'";
            Object[] params = {personal.getXINMIN(), personal.getSHENFENZHEN(), personal.getSHENRI(),
                    personal.getXINBIE(), personal.getBIYEYUANXIAO(), personal.getGONGZUONIANYUE(), personal.getZHIWU(),
                    personal.getZHICHEN(), personal.getJISHUZHIWU(), personal.getZHENZHIMIANMAO(), personal.getJIATINZHUZHI(),
                    personal.getSHOUJI(), personal.getZHAIDIAN(), personal.getXUELI(), personal.getJIGUAN()};
            System.out.println("dbservice.updatePersonal;SQL=" + sql);
            queryRunner.update(conn, sql, params);

        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
    }

    public void updatePersonalwithAllInfoBean(Personal personal) {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "UPDATE personal set XINMIN=? , SHENFENZHEN=? , SHENRI=? , XINBIE=? , BIYEYUANXIAO=? , GONGZUONIANYUE=? " +
                    ", ZHIWU=? , ZHICHEN=? , JISHUZHIWU=? , ZHENZHIMIANMAO=? , JIATINZHUZHI=? , SHOUJI=? , ZHAIDIAN=? , " +
                    "XUELI=? , JIGUAN=? where PID = '" + personal.getPID() + "'";
            Object[] params = {personal.getXINMIN(), personal.getSHENFENZHEN(), personal.getSHENRI(),
                    personal.getXINBIE(), personal.getBIYEYUANXIAO(), personal.getGONGZUONIANYUE(), personal.getZHIWU(),
                    personal.getZHICHEN(), personal.getJISHUZHIWU(), personal.getZHENZHIMIANMAO(), personal.getJIATINZHUZHI(),
                    personal.getSHOUJI(), personal.getZHAIDIAN(), personal.getXUELI(), personal.getJIGUAN()};
            System.out.println("dbservice.updatePersonal;SQL=" + sql);
            queryRunner.update(conn, sql, params);

        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
    }

    public void deletePersonal(Personal personal) {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "delete from personal where PID=?";
            queryRunner.update(conn, sql, personal.getPID());
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
    }

    public Personal login(String username, String password) {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        Personal personalSession = new Personal();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "SELECT * FROM account a,personal p where p.XINMIN = '" + username + "' and a.ACCOUNTPASSWORD = '" + password + "' and p.PID = a.PID";
            List<Map<String, Object>> mapList = queryRunner.query(conn, sql, new MapListHandler());
            for (Map<String, Object> map : mapList) {
                Account account = new Account();
                BeanUtils.copyProperties(personalSession, map);
                BeanUtils.copyProperties(account, map);
                personalSession.setACCOUNT(account);
            }
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return personalSession;
    }

    public List<Personal> listPersonalIsDangyuan() {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        List<Personal> personalList = new ArrayList<Personal>();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            BeanListHandler<Personal> beanListHandler = new BeanListHandler<Personal>(Personal.class);
            String sql = "SELECT * FROM PERSONAL WHERE ZHENZHIMIANMAO LIKE '党员%' ORDER BY PID";
            personalList = queryRunner.query(conn, sql, beanListHandler);
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return personalList;
    }

    public List<Personal> listPersonalIsTuanyuan() {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        List<Personal> personalList = new ArrayList<Personal>();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            BeanListHandler<Personal> beanListHandler = new BeanListHandler<Personal>(Personal.class);
            personalList = queryRunner.query(conn, "SELECT * FROM personal where ZHENZHIMIANMAO LIKE '共青团员%' ORDER BY PID", beanListHandler);
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return personalList;
    }

    public List<Personal> searchByKeyword(String keyword) {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        List<Personal> personalList = new ArrayList<Personal>();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            BeanListHandler<Personal> beanListHandler = new BeanListHandler<Personal>(Personal.class);
            personalList = queryRunner.query(conn, "SELECT * FROM personal where concat(IFNULL(XINMIN,''),IFNULL(SHENRI,'')" +
                    ",IFNULL(JIGUAN,''),IFNULL(XUELI,''),IFNULL(BIYEYUANXIAO,''),IFNULL(GONGZUONIANYUE,''),IFNULL(ZHIWU,''),IFNULL(ZHICHEN,'')," +
                    "IFNULL(JISHUZHIWU,''),IFNULL(ZHENZHIMIANMAO,''),IFNULL(JIATINZHUZHI,''),IFNULL(SHOUJI,''),IFNULL(ZHAIDIAN,'')) like '%"
                    + keyword + "%'", beanListHandler);
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return personalList;
    }

    public List<Personal> listZhizhao() {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        List<Personal> personalList = new ArrayList<Personal>();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            List<Map<String, Object>> mapList = queryRunner.query(conn, "select * from personal p,zhizhao z where p.pid = z.pid", new MapListHandler());
            for (Map<String, Object> map : mapList) {
                Personal personal = new Personal();
                Zhizhao zhizhao = new Zhizhao();
                BeanUtils.copyProperties(personal, map);
                BeanUtils.copyProperties(zhizhao, map);
                personal.setZHIZHAO(zhizhao);
                personalList.add(personal);
            }
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return personalList;
    }

    public List<Personal> listPersonalCar() {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        List<Personal> personalList = new ArrayList<Personal>();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            List<Map<String, Object>> mapList = queryRunner.query(conn, "select * from personal p,car c where p.pid = c.pid", new MapListHandler());
            for (Map<String, Object> map : mapList) {
                Personal personal = new Personal();
                Car car = new Car();
                BeanUtils.copyProperties(personal, map);
                BeanUtils.copyProperties(car, map);
                personal.setCAR(car);
                personalList.add(personal);
            }
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return personalList;
    }

    public List<Personal> listPersonalChild() {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        List<Personal> personalList = new ArrayList<Personal>();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            List<Map<String, Object>> mapList = queryRunner.query(conn, "select * from personal p,child c where p.pid = c.pid", new MapListHandler());
            for (Map<String, Object> map : mapList) {
                Personal personal = new Personal();
                Child child = new Child();
                BeanUtils.copyProperties(personal, map);
                BeanUtils.copyProperties(child, map);
                personal.setCHILD(child);
                personalList.add(personal);
            }
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return personalList;
    }

    public boolean insertPersonal(Personal p) {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "insert into PERSONAL (PID,XINMIN,SHENFENZHEN,SHENRI,XINBIE,BIYEYUANXIAO,GONGZUONIANYUE,ZHIWU,ZHICHEN,JISHUZHIWU" +
                    ",ZHENZHIMIANMAO,JIATINZHUZHI,SHOUJI,ZHAIDIAN,XUELI,JIGUAN) VALUES " +
                    "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            Object[] params = {getMaxPid("PERSONAL") + 1, p.getXINMIN(), p.getSHENFENZHEN(), p.getSHENRI(), p.getXINBIE(), p.getBIYEYUANXIAO(), p.getGONGZUONIANYUE(), p.getZHIWU()
                    , p.getZHICHEN(), p.getJISHUZHIWU(), p.getZHENZHIMIANMAO(), p.getJIATINZHUZHI(), p.getSHOUJI(), p.getZHAIDIAN(), p.getXUELI(), p.getJIGUAN()};
            queryRunner.update(conn, sql, params);
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
            return false;
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
            return false;
        }
        return true;
    }

    public boolean insertZHIZHAO(Zhizhao z, Personal p) {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "insert into ZHIZHAO (ZHIZHAOTYPE , PID , ZHIZHAODATEFROM , ZHIZHAODATETO , ZHIZHAOID) VALUES " +
                    "(?,?,?,?,?)";
            Object[] params = {z.getZHIZHAOTYPE(), p.getPID(), z.getZHIZHAODATEFROM(), z.getZHIZHAODATETO(), getMaxZHIZHAOID() + 1};
            queryRunner.update(conn, sql, params);
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
            return false;
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
            return false;
        }
        return true;
    }

    public boolean insertCHILD(Child c, Personal p) {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "insert into CHILD (PID , CHILDXINMIN , CHILDSHENRI , CHILDXINBIE , CHILDID) VALUES " +
                    "(?,?,?,?,?)";
            Object[] params = {p.getPID(), c.getCHILDXINMIN(), c.getCHILDSHENRI(), c.getCHILDXINBIE(), getMaxCHILDID() + 1};
            queryRunner.update(conn, sql, params);
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
            return false;
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
            return false;
        }
        return true;
    }

    public boolean insertCar(Car c, Personal p) {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "insert into CAR (PID , CARCHEPAI , CARDENJIDATE , CARID) VALUES " +
                    "(?,?,?,?)";
            Object[] params = {p.getPID(), c.getCARCHEPAI(), c.getCARDENJIDATE(), getMaxCARID() + 1};
            queryRunner.update(conn, sql, params);
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
            return false;
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
            return false;
        }
        return true;
    }

    public void updateZhizhao(Zhizhao z) {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "UPDATE ZHIZHAO set ZHIZHAOTYPE = ? , ZHIZHAODATEFROM=? , ZHIZHAODATETO=? where ZHIZHAOID = ?";
            Object[] params = {z.getZHIZHAOTYPE(), z.getZHIZHAODATEFROM(), z.getZHIZHAODATETO(), z.getZHIZHAOID()};
            System.out.println("dbservice.updateZhizhao;SQL=" + sql);
            queryRunner.update(conn, sql, params);

        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
    }

    public void updateCar(Car c) {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "UPDATE CAR set CARCHEPAI = ? , CARDENJIDATE=? where CARID = '" + c.getCARID() + "'";
            Object[] params = {c.getCARCHEPAI(), c.getCARDENJIDATE()};
            System.out.println("dbservice.updateCar;SQL=" + sql);
            queryRunner.update(conn, sql, params);

        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
    }

    public void updateChild(Child c) {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "UPDATE CHILD set CHILDXINMIN = ? , CHILDSHENRI=? , CHILDXINBIE=? where CHILDID = '" + c.getCHILDID() + "'";
            Object[] params = {c.getCHILDXINMIN(), c.getCHILDSHENRI(), c.getCHILDXINBIE()};
            System.out.println("dbservice.updateChild;SQL=" + sql);
            queryRunner.update(conn, sql, params);

        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
    }

    public void deleteZhizhao(Zhizhao z) {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "delete from ZHIZHAO where ZHIZHAOID=?";
            System.out.println("dbservice.deleteZhizhao;SQL=" + sql);
            queryRunner.update(conn, sql, z.getZHIZHAOID());
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
    }

    public void deleteCar(Car c) {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "delete from CAR where CARID=?";
            System.out.println("dbservice.deleteCar;SQL=" + sql);
            queryRunner.update(conn, sql, c.getCARID());
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
    }

    public void deleteChild(Child c) {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "delete from CHILD where CHILDID=?";
            System.out.println("dbservice.deleteChild;SQL=" + sql);
            queryRunner.update(conn, sql, c.getCHILDID());
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
    }

    public int getMaxPid(String tablename) {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        Object obj = 0;
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            obj = queryRunner.query(conn, "SELECT MAX(PID) PID FROM " + tablename, new ScalarHandler<Object>("PID"));
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return Integer.parseInt(obj.toString());
    }

    public int getMaxTid(String tablename) {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        Object obj = 0;
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            obj = queryRunner.query(conn, "SELECT MAX(TID) TID FROM " + tablename, new ScalarHandler<Object>("TID"));
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return Integer.parseInt(obj.toString());
    }

    public int getMaxZHIZHAOID() {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        Object obj = 0;
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            obj = queryRunner.query(conn, "SELECT MAX(ZHIZHAOID) ZHIZHAOID FROM ZHIZHAO", new ScalarHandler<Object>("ZHIZHAOID"));
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return Integer.parseInt(obj.toString());
    }

    public int getMaxCARID() {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        Object obj = 0;
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            obj = queryRunner.query(conn, "SELECT MAX(CARID) CARID FROM CAR", new ScalarHandler<Object>("CARID"));
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return Integer.parseInt(obj.toString());
    }

    public int getMaxCHILDID() {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        Object obj = 0;
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            obj = queryRunner.query(conn, "SELECT MAX(CHILDID) CHILDID FROM CHILD", new ScalarHandler<Object>("CHILDID"));
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return Integer.parseInt(obj.toString());
    }

    public boolean insertTraining(Training t) {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "insert into TRAINING (TID , TRAININGDATE , SUBJECT , LOCATION , GOAL , SPEAKER , NOTEKEEPER , CONTENT , EVALUATION , REMARK , CLASSHOUR) VALUES " +
                    "(?,?,?,?,?,?,?,?,?,?,?)";
            Object[] params = {getMaxTid("TRAINING") + 1, t.getTRAININGDATE(), t.getSUBJECT(),t.getLOCATION(),t.getGOAL(),t.getSPEAKER(),t.getNOTEKEEPER(),t.getCONTENT(),t.getEVALUATION(),t.getREMARK(),t.getCLASSHOUR()};
            queryRunner.update(conn, sql, params);
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
            return false;
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
            return false;
        }
        return true;
    }

    public void updateTraining(Training training) {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "UPDATE TRAINING set TRAININGDATE=? , SUBJECT=? , LOCATION=? , GOAL=? , SPEAKER=? , NOTEKEEPER=? " +
                    ", CONTENT=? , EVALUATION=? , REMARK=? , CLASSHOUR=?  where TID = '" + training.getTID() + "'";
            Object[] params = {training.getTRAININGDATE(),training.getSUBJECT(), training.getLOCATION(), training.getGOAL(),
                    training.getSPEAKER(), training.getNOTEKEEPER(), training.getCONTENT(), training.getEVALUATION(),
                    training.getREMARK(), training.getCLASSHOUR()};
            System.out.println("dbservice.updatetraining;SQL=" + sql);
            queryRunner.update(conn, sql, params);

        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }

    }

    public void deleteTraining(Training t) {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        try {
            DbUtils.loadDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "delete from TRAINING where TID=?";
            System.out.println("dbservice.deleteChild;SQL=" + sql);
            queryRunner.update(conn, sql, t.getTID());
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
    }
}