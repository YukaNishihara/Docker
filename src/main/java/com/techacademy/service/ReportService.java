package com.techacademy.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techacademy.constants.ErrorKinds;
import com.techacademy.entity.Report;
import com.techacademy.repository.ReportRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class ReportService {

    private final ReportRepository reportRepository;
    

    @Autowired
    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
        
    }
    //新規登録
//    @Transactional
//    public ErrorKinds save(Report report) {
//
//        report.setDeleteFlg(false);
//        
//        
//        //作成日時、更新日時
//        LocalDateTime now = LocalDateTime.now();
//        report.setCreatedAt(now);
//        report.setUpdatedAt(now);
//       
//
//        reportRepository.save(report);
//        return ErrorKinds.SUCCESS;
//    }


    // 日報一覧表示処理
    public List<Report> findAll() {
        return reportRepository.findAll();
    }

    // 1件を検索
    public Report findByCode(String id) {
        // findByIdで検索
        Optional<Report> option = reportRepository.findById(id);
        
      Report report = option.orElse(null);
        return report;
    }

  
}
