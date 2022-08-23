package com.example.cbr.repository;

import com.example.cbr.domain.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
      @Query(value = "SELECT date, value FROM tbl_currency b WHERE b.char_code LIKE %:charcode% AND b.date LIKE DATEADD(DAY, -:day, GETDATE()) ",  nativeQuery = true)
      List<Currency> getCurrByDate(@Param("day") Integer day, @Param("charcode") String charcode);

      @Query(value = "SELECT char_code FROM tbl_currency b",  nativeQuery = true)
      List<Currency> getValute();

      @Query(value = "SELECT * FROM tbl_currency b WHERE b.char_code LIKE %:charcode% AND b.date BETWEEN :first_date AND :second_date",  nativeQuery = true)
      List<Currency> getPersentValute(@Param("charcode") String charcode, @Param("first_date") Date first_date, @Param("second_date") Date second_date);

}
