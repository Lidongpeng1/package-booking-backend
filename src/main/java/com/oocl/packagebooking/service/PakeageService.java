package com.oocl.packagebooking.service;

import com.oocl.packagebooking.entity.Pakeage;
import com.oocl.packagebooking.exception.ReapplyException;
import com.oocl.packagebooking.repository.PakeageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PakeageService {

        @Autowired
        private
        PakeageRepository pakeageRepository;

        public void addPageage(Pakeage pakeage) { //添加包裹,包裹入库
            pakeageRepository.saveAndFlush(pakeage);
        }

        public List<Pakeage> findAll() {  //查找所有包裹
            return pakeageRepository.findAll();
        }

        public ResponseEntity getOne(String id) {  //根据id查询包裹
            Pakeage pakeage = pakeageRepository.findById(id).get();
            return ResponseEntity.ok().body(pakeage);
        }

        public ResponseEntity applyPakeage(Pakeage pakeage, String id ,String appointment) throws ReapplyException {  //预约取件
            Pakeage pakeageDb = pakeageRepository.findById(id).get();
            Integer state = pakeageDb.getState();
            if(state != 1){
                throw new ReapplyException("您已经预约过");
            }
            pakeageDb.setState(state+1);
            pakeageDb.setAppointment(appointment);
            return ResponseEntity.ok().body(pakeageDb);
        }


        public ResponseEntity fetchPakeage(Pakeage pakeage, String id) throws ReapplyException {  //确认收货
            Pakeage pakeageDb = pakeageRepository.findById(id).get();
            Integer state = pakeageDb.getState();
            if(state != 2){
                throw new ReapplyException("该件已取出");
            }
            pakeageDb.setState(state+1);
            return ResponseEntity.ok().body(pakeageDb);
        }

        public ResponseEntity findPakeageByState(String state) throws ReapplyException {  //根据状态查询包裹
            List<Pakeage> pakeages = pakeageRepository.findByState(state);
            return ResponseEntity.ok().body(pakeages);
        }

}
