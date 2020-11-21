package com.pi.action;

import com.pi.bean.*;
import com.pi.service.dbservice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class webaction {
    public Personal personalSession = new Personal();
    public Personal personalbean = new Personal();
    public Training trainingbean = new Training();
    public dbservice dbservice = new dbservice();
    public String pid;
    public int tid;
    public List<Personal> personalList = new ArrayList<Personal>();
    public List<Zhizhao> zhizhaoList = new ArrayList<Zhizhao>();
    public List<Car> carList = new ArrayList<Car>();
    public List<Child> childList = new ArrayList<Child>();
    public List<Training> trainingList = new ArrayList<Training>();
    public List<Person2training> person2trainingList = new ArrayList<Person2training>();
    public List<Person2training> joinedperson2trainingList = new ArrayList<Person2training>();
    public List<Person2training> absentperson2trainingList = new ArrayList<Person2training>();
    public List<String> namelists = new ArrayList<String>();
    public List<Plan> planList = new ArrayList<Plan>();
    public List<Person2training> t2pList = new ArrayList<Person2training>();

    public String searchKeyword;
    public String username;
    public String password;

    public Personal getPersonalSession() {
        return personalSession;
    }

    public void setPersonalSession(Personal personalSession) {
        this.personalSession = personalSession;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public Personal getPersonalbean() {
        return personalbean;
    }

    public void setPersonalbean(Personal personalbean) {
        this.personalbean = personalbean;
    }


    public String login() {
        personalSession = dbservice.login(username, password);
        if (0 != personalSession.getPID()) {
            System.out.println("PID=" + personalSession.getPID() + ";" + personalSession.getXINMIN().trim() + "; AccountPower=" + personalSession.getACCOUNT().getACCOUNTPOWER() + "; Login success;");
            System.out.println("PutInto personalSession;");
            return "success";
        } else {
            System.out.println("PID=" + personalSession.getPID() + ";" + personalSession.getXINMIN().trim() + "; AccountPower=" + personalSession.getACCOUNT().getACCOUNTPOWER() + "; Login denied;");
            return "input";
        }
    }

    public String listPersonal() {
        personalList = dbservice.listPersonal();
        return "success";
    }

     public String listTraining() {
        trainingList = dbservice.listTraining();
        return "success";
    }

    public String listPersonalIsDangyuan() {
        personalList = dbservice.listPersonalIsDangyuan();
        return "success";
    }

    public String listPersonalIsTuanyuan() {
        personalList = dbservice.listPersonalIsTuanyuan();
        return "success";
    }

    public String listPersonalZhizhao() {
        personalList = dbservice.listZhizhao();
        return "success";
    }

    public String listPersonalTele() {
        personalList = dbservice.listPersonal();
        return "success";
    }

    public String listPersonalCar() {
        personalList = dbservice.listPersonalCar();
        return "success";
    }

    public String search() {
        personalList = dbservice.searchByKeyword(searchKeyword);
        return "success";
    }

    public String personalEditLoad() {
        //basic personal info
        personalbean = dbservice.getPersonalBeanByPid(pid);
        //put car child zhizhao info into personalbean
        carList = dbservice.listCarBeanByPid(pid);
        zhizhaoList = dbservice.listZhizhaoBeanByPid(pid);
        childList = dbservice.listChildBeanByPid(pid);
        if (zhizhaoList.size() > 0)
            personalbean.setZHIZHAO(zhizhaoList.get(0));
        if (zhizhaoList.size() > 1)
            personalbean.setZHIZHAO2(zhizhaoList.get(1));
        if (zhizhaoList.size() > 2)
            personalbean.setZHIZHAO3(zhizhaoList.get(2));
        if (carList.size() > 0)
            personalbean.setCAR(carList.get(0));
        if (carList.size() > 1)
            personalbean.setCAR2(carList.get(1));
        if (carList.size() > 2)
            personalbean.setCAR3(carList.get(2));
        if (childList.size() > 0)
            personalbean.setCHILD(childList.get(0));
        if (childList.size() > 1)
            personalbean.setCHILD2(childList.get(1));
        if (childList.size() > 2)
            personalbean.setCHILD3(childList.get(2));
        //done
        return "success";
    }

    public String trainingEditLoad() {
        //basic training info

        trainingbean = dbservice.getTrainingBeanByTid(tid);
        person2trainingList = dbservice.person2trainingListByTid(tid);
        personalList = dbservice.listPersonal();
        personalList.forEach(personal-> {
            if (person2trainingList.stream().filter(o -> o.getPID() == personal.getPID()).count() > 0){
                Stream<Person2training> p2tList = person2trainingList.stream().filter(o -> o.getPID() == personal.getPID());
                Person2training p2t = p2tList.findFirst().get();
                p2t.setXINMIN(personal.getXINMIN());
                joinedperson2trainingList.add(p2t);
                absentperson2trainingList.add(p2t);
            }else {
                Person2training newP2t = new Person2training();
                newP2t.setPID(personal.getPID());
                newP2t.setTID(tid);
                newP2t.setXINMIN(personal.getXINMIN());
                joinedperson2trainingList.add(newP2t);
                absentperson2trainingList.add(newP2t);
            }
            namelists.add(personal.getXINMIN());
            }
        );
        trainingbean.setPERSON2TRAINING(absentperson2trainingList);
        return "success";
    }

    public String updatePersonal() {
        //for basic personal info
        if (personalbean.getPID() == 0) {
            dbservice.insertPersonal(personalbean);
        } else {
            dbservice.updatePersonal(personalbean);
        }
        //for zhizhao car child info update
        if (personalbean.getZHIZHAO().getZHIZHAOID() != 0 && !"".equals(personalbean.getZHIZHAO().getZHIZHAOTYPE())) {
            dbservice.updateZhizhao(personalbean.getZHIZHAO());
        } else if (personalbean.getZHIZHAO().getZHIZHAOID() == 0 && !"".equals(personalbean.getZHIZHAO().getZHIZHAOTYPE())) {
            dbservice.insertZHIZHAO(personalbean.getZHIZHAO(), personalbean);
        } else if (personalbean.getZHIZHAO().getZHIZHAOID() != 0 && "".equals(personalbean.getZHIZHAO().getZHIZHAOTYPE())) {
            dbservice.deleteZhizhao(personalbean.getZHIZHAO());
        }

        if (personalbean.getZHIZHAO2().getZHIZHAOID() != 0 && !"".equals(personalbean.getZHIZHAO2().getZHIZHAOTYPE())) {
            dbservice.updateZhizhao(personalbean.getZHIZHAO2());
        } else if (personalbean.getZHIZHAO2().getZHIZHAOID() == 0 && !"".equals(personalbean.getZHIZHAO2().getZHIZHAOTYPE())) {
            dbservice.insertZHIZHAO(personalbean.getZHIZHAO2(), personalbean);
        } else if (personalbean.getZHIZHAO2().getZHIZHAOID() != 0 && "".equals(personalbean.getZHIZHAO2().getZHIZHAOTYPE())) {
            dbservice.deleteZhizhao(personalbean.getZHIZHAO2());
        }

        if (personalbean.getZHIZHAO3().getZHIZHAOID() != 0 && !"".equals(personalbean.getZHIZHAO3().getZHIZHAOTYPE())) {
            dbservice.updateZhizhao(personalbean.getZHIZHAO3());
        } else if (personalbean.getZHIZHAO3().getZHIZHAOID() == 0 && !"".equals(personalbean.getZHIZHAO3().getZHIZHAOTYPE())) {
            dbservice.insertZHIZHAO(personalbean.getZHIZHAO3(), personalbean);
        } else if (personalbean.getZHIZHAO3().getZHIZHAOID() != 0 && "".equals(personalbean.getZHIZHAO3().getZHIZHAOTYPE())) {
            dbservice.deleteZhizhao(personalbean.getZHIZHAO3());
        }

        if (personalbean.getCAR().getCARID() != 0 && !"".equals(personalbean.getCAR().getCARCHEPAI())) {
            dbservice.updateCar(personalbean.getCAR());
        } else if (personalbean.getCAR().getCARID() == 0 && !"".equals(personalbean.getCAR().getCARCHEPAI())) {
            dbservice.insertCar(personalbean.getCAR(), personalbean);
        } else if (personalbean.getCAR().getCARID() != 0 && "".equals(personalbean.getCAR().getCARCHEPAI())) {
            dbservice.deleteCar(personalbean.getCAR());
        }

        if (personalbean.getCAR2().getCARID() != 0 && !"".equals(personalbean.getCAR2().getCARCHEPAI())) {
            dbservice.updateCar(personalbean.getCAR2());
        } else if (personalbean.getCAR2().getCARID() == 0 && !"".equals(personalbean.getCAR2().getCARCHEPAI())) {
            dbservice.insertCar(personalbean.getCAR2(), personalbean);
        } else if (personalbean.getCAR2().getCARID() != 0 && "".equals(personalbean.getCAR2().getCARCHEPAI())) {
            dbservice.deleteCar(personalbean.getCAR2());
        }

        if (personalbean.getCAR3().getCARID() != 0 && !"".equals(personalbean.getCAR3().getCARCHEPAI())) {
            dbservice.updateCar(personalbean.getCAR3());
        } else if (personalbean.getCAR3().getCARID() == 0 && !"".equals(personalbean.getCAR3().getCARCHEPAI())) {
            dbservice.insertCar(personalbean.getCAR3(), personalbean);
        } else if (personalbean.getCAR3().getCARID() != 0 && "".equals(personalbean.getCAR3().getCARCHEPAI())) {
            dbservice.deleteCar(personalbean.getCAR3());
        }

        if (personalbean.getCHILD().getCHILDID() != 0 && !"".equals(personalbean.getCHILD().getCHILDXINMIN())) {
            dbservice.updateChild(personalbean.getCHILD());
        } else if (personalbean.getCHILD().getCHILDID() == 0 && !"".equals(personalbean.getCHILD().getCHILDXINMIN())) {
            dbservice.insertCHILD(personalbean.getCHILD(), personalbean);
        } else if (personalbean.getCHILD().getCHILDID() != 0 && "".equals(personalbean.getCHILD().getCHILDXINMIN())) {
            dbservice.deleteChild(personalbean.getCHILD());
        }

        if (personalbean.getCHILD2().getCHILDID() != 0 && !"".equals(personalbean.getCHILD2().getCHILDXINMIN())) {
            dbservice.updateChild(personalbean.getCHILD2());
        } else if (personalbean.getCHILD2().getCHILDID() == 0 && !"".equals(personalbean.getCHILD2().getCHILDXINMIN())) {
            dbservice.insertCHILD(personalbean.getCHILD2(), personalbean);
        } else if (personalbean.getCHILD2().getCHILDID() != 0 && "".equals(personalbean.getCHILD2().getCHILDXINMIN())) {
            dbservice.deleteChild(personalbean.getCHILD2());
        }

        if (personalbean.getCHILD3().getCHILDID() != 0 && !"".equals(personalbean.getCHILD3().getCHILDXINMIN())) {
            dbservice.updateChild(personalbean.getCHILD3());
        } else if (personalbean.getCHILD3().getCHILDID() == 0 && !"".equals(personalbean.getCHILD3().getCHILDXINMIN())) {
            dbservice.insertCHILD(personalbean.getCHILD3(), personalbean);
        } else if (personalbean.getCHILD3().getCHILDID() != 0 && "".equals(personalbean.getCHILD3().getCHILDXINMIN())) {
            dbservice.deleteChild(personalbean.getCHILD3());
        }
        return "success";
    }

    public String updateTraining() {
        //for basic personal info
        if (trainingbean.getTID() == 0) {
            dbservice.insertTraining(trainingbean);
        } else {
            dbservice.updateTraining(trainingbean);
        }

        return "success";
    }

    public String insertPersonal() {
        dbservice.insertPersonal(personalbean);
        return "success";
    }

    public String insertTraining() {
        dbservice.insertTraining(trainingbean);
        return "success";
    }

    public String listPersonalChild() {
        personalList = dbservice.listPersonalChild();
        return "success";
    }
}
