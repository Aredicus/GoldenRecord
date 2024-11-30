package ru.golden.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.golden.functional_interface.Correct;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Objects;

import static java.util.Objects.isNull;
import static ru.golden.enums.DataFormat.*;
import static ru.golden.util.GoldenUtil.*;

@Getter
@NoArgsConstructor
@Accessors
public class Data implements Correct {
    private Long clientId;
    private String clientFirstName;
    private String clientMiddleName;
    private String clientLastName;
    private String clientFioFull;
    private LocalDateTime clientBday;
    @Setter
    private String clientBplace;
    @Setter
    private String clientCityzen;
    @Setter
    private String clientResidentCd;
    @Setter
    private String clientGender;
    @Setter
    private String clientMaritalCd;
    private Boolean clientGraduate;
    private Double clientChildCnt;
    @Setter
    private String clientMilCd;
    @Setter
    private String clientZagranCd;
    private String clientInn;
    private String clientSnils;
    @Setter
    private String clientVipCd;
    @Setter
    private String contactVc;
    private String contactTg;
    @Setter
    private String contactOther;
    private String contactEmail;
    private String contactPhone;
    @Setter
    private String addrRegion;
    @Setter
    private String addrCountry;
    @Setter
    private String addrZip;
    @Setter
    private String addrStreet;
    @Setter
    private String addrHouse;
    @Setter
    private String addrBody;
    @Setter
    private String addrFlat;
    @Setter
    private String addrArea;
    @Setter
    private String addrLoc;
    @Setter
    private String addrCity;
    private LocalDateTime addrRegDt;
    @Setter
    private String addrStr;
    private Double finRating;
    private Double finLoanLimit;
    private Double finLoanValue;
    private Double finLoanDebt;
    private Double finLoanPercent;
    private LocalDateTime finLoanBeginDt;
    private LocalDateTime finLoanEndDt;
    @Setter
    private String streamFavoriteShow;
    private Integer streamDuration;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    @Setter
    private String sourceCd;

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName.toLowerCase(Locale.ROOT);
    }

    public void setClientMiddleName(String clientMiddleName) {
        this.clientMiddleName = clientMiddleName.toLowerCase(Locale.ROOT);
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName.toLowerCase(Locale.ROOT);
    }

    public void setClientFioFull(String clientFioFull) {
        this.clientFioFull = String.join("", clientFioFull.split(" ")).toLowerCase(Locale.ROOT);
    }

    public void setClientBday(String clientBday) {
        this.clientBday = parseDate(clientBday, BIRTH_DAY);
    }

    public void setClientInn(String clientInn) {
        clientInn = String.join("", clientInn.split(" "));
        this.clientInn = isInnCorrect(clientInn) ? clientInn : null;
    }

    public void setClientSnils(String clientSnils) {
        clientSnils = String.join("", clientSnils.split("[ -]"));
        this.clientSnils = isSnilsCorrect(clientSnils) ? clientSnils : null;
    }

    public void setContactTg(String contactTg) {
        contactTg = contactTg.replaceAll("^(?:https?:\\/\\/)?t.me\\/", "@");
        this.contactTg = isTgCorrect(contactTg) ? contactTg : null;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = isEmailCorrect(contactEmail) ? contactEmail : null;
    }

    public void setContactPhone(String contactPhone) {
        contactPhone = String.join("", " ").replaceFirst("^8", "+7");
        this.contactPhone = isPhoneCorrect(contactPhone) ? contactPhone : null;
    }

    public void setCreateDate(String createDate) {
        this.createDate = parseDate(createDate, CREATE_DATE);
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = parseDate(updateDate, UPDATE_DATE);
    }

    // Метод toString для удобного вывода информации об объекте
    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", clientFirstName='" + clientFirstName + '\'' +
                ", clientMiddleName='" + clientMiddleName + '\'' +
                ", clientLastName='" + clientLastName + '\'' +
                ", clientFioFull='" + clientFioFull + '\'' +
                ", clientBday=" + clientBday +
                ", clientBplace='" + clientBplace + '\'' +
                ", clientCityzen='" + clientCityzen + '\'' +
                ", clientResidentCd='" + clientResidentCd + '\'' +
                ", clientGender='" + clientGender + '\'' +
                ", clientMaritalCd='" + clientMaritalCd + '\'' +
                ", clientGraduate=" + clientGraduate +
                ", clientChildCnt=" + clientChildCnt +
                ", clientMilCd='" + clientMilCd + '\'' +
                ", clientZagranCd='" + clientZagranCd + '\'' +
                ", clientInn='" + clientInn + '\'' +
                ", clientSnils='" + clientSnils + '\'' +
                ", clientVipCd='" + clientVipCd + '\'' +
                ", contactVc='" + contactVc + '\'' +
                ", contactTg='" + contactTg + '\'' +
                ", contactOther='" + contactOther + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", addrRegion='" + addrRegion + '\'' +
                ", addrCountry='" + addrCountry + '\'' +
                ", addrZip='" + addrZip + '\'' +
                ", addrStreet='" + addrStreet + '\'' +
                ", addrHouse='" + addrHouse + '\'' +
                ", addrBody='" + addrBody + '\'' +
                ", addrFlat='" + addrFlat + '\'' +
                ", addrArea='" + addrArea + '\'' +
                ", addrLoc='" + addrLoc + '\'' +
                ", addrCity='" + addrCity + '\'' +
                ", addrRegDt=" + addrRegDt +
                ", addrStr='" + addrStr + '\'' +
                ", finRating=" + finRating +
                ", finLoanLimit=" + finLoanLimit +
                ", finLoanValue=" + finLoanValue +
                ", finLoanDebt=" + finLoanDebt +
                ", finLoanPercent=" + finLoanPercent +
                ", finLoanBeginDt=" + finLoanBeginDt +
                ", finLoanEndDt=" + finLoanEndDt +
                ", streamFavoriteShow='" + streamFavoriteShow + '\'' +
                ", streamDuration=" + streamDuration +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", sourceCd='" + sourceCd + '\'' +
                '}';
    }

    public String toCsvFormat() {
        return correctCsv(clientId) +
                "," + correctCsv(clientFirstName) +
                "," + correctCsv(clientMiddleName) +
                "," + correctCsv(clientLastName) +
                "," + correctCsv(clientFioFull) +
                "," + correctCsv(clientBday) +
                "," + correctCsv(clientBplace) +
                "," + correctCsv(clientCityzen) +
                "," + correctCsv(clientResidentCd) +
                "," + correctCsv(clientGender) +
                "," + correctCsv(clientMaritalCd) +
                "," + correctCsv(clientGraduate) +
                "," + correctCsv(clientChildCnt) +
                "," + correctCsv(clientMilCd) +
                "," + correctCsv(clientZagranCd) +
                "," + correctCsv(clientInn) +
                "," + correctCsv(clientSnils) +
                "," + correctCsv(clientVipCd) +
                "," + correctCsv(contactVc) +
                "," + correctCsv(contactTg) +
                "," + correctCsv(contactOther) +
                "," + correctCsv(contactEmail) +
                "," + correctCsv(contactPhone) +
                "," + correctCsv(addrRegion) +
                "," + correctCsv(addrCountry) +
                "," + correctCsv(addrZip) +
                "," + correctCsv(addrStreet) +
                "," + correctCsv(addrHouse) +
                "," + correctCsv(addrBody) +
                "," + correctCsv(addrFlat) +
                "," + correctCsv(addrArea) +
                "," + correctCsv(addrLoc) +
                "," + correctCsv(addrCity) +
                "," + correctCsv(addrRegDt) +
                "," + correctCsv(addrStr) +
                "," + correctCsv(finRating) +
                "," + correctCsv(finLoanLimit) +
                "," + correctCsv(finLoanValue) +
                "," + correctCsv(finLoanDebt) +
                "," + correctCsv(finLoanPercent) +
                "," + correctCsv(finLoanBeginDt) +
                "," + correctCsv(finLoanEndDt) +
                "," + correctCsv(streamFavoriteShow) +
                "," + correctCsv(streamDuration) +
                "," + correctCsv(createDate) +
                "," + correctCsv(updateDate) +
                "," + correctCsv(sourceCd);
    }

    private String correctCsv(Object val) {
        return Objects.isNull(val) ? "" : val.toString();
    }

    public void setClientGraduate(String clientGraduate) {
        if (isNull(clientGraduate)) {
            this.clientGraduate = null;
            return;
        }
        this.clientGraduate = "Д".equals(clientGraduate);
    }

    public void setClientChildCnt(String clientChildCnt) {
        try {
            this.clientChildCnt = Double.parseDouble(clientChildCnt);
        } catch (NumberFormatException e) {
            this.clientChildCnt = null;
        }
    }

    public void setFinRating(String finRating) {
        try {
            this.finRating = Double.parseDouble(finRating);
        } catch (NumberFormatException e) {
            this.finRating = null;
        }
    }

    public void setFinLoanLimit(String finLoanLimit) {
        try {
            this.finLoanLimit = Double.parseDouble(finLoanLimit);
        } catch (NumberFormatException e) {
            this.finLoanLimit = null;
        }
    }

    public void setFinLoanValue(String finLoanValue) {
        try {
            this.finLoanValue = Double.parseDouble(finLoanValue);
        } catch (NumberFormatException e) {
            this.finLoanValue = null;
        }
    }

    public void setFinLoanDebt(String finLoanDebt) {
        try {
            this.finLoanDebt = Double.parseDouble(finLoanDebt);
        } catch (NumberFormatException e) {
            this.finLoanDebt = null;
        }
    }

    public void setFinLoanPercent(String finLoanPercent) {
        try {
            this.finLoanPercent = Double.parseDouble(finLoanPercent);
        } catch (NumberFormatException e) {
            this.finLoanPercent = null;
        }
    }

    public void setStreamDuration(String streamDuration) {
        try {
            this.streamDuration = Integer.parseInt(streamDuration);
        } catch (NumberFormatException e) {
            this.streamDuration = null;
        }
    }

    public void setClientId(String clientId) {
        try {
            this.clientId = Long.parseLong(clientId);
        } catch (NumberFormatException e) {
            this.clientId = null;
        }
    }

    public void setFinLoanBeginDt(String finLoanBeginDt) {
        this.finLoanBeginDt = parseDate(finLoanBeginDt, FIN_DATE);
    }

    public void setFinLoanEndDt(String finLoanEndDt) {
        this.finLoanEndDt = parseDate(finLoanEndDt, FIN_DATE);
    }

    public void setAddrRegDt(String addrRegDt) {
        this.addrRegDt = parseDate(addrRegDt, FIN_DATE);
    }

    @Override
    public boolean isCorrect() {
        int counter = 0;
        counter += Objects.isNull(contactTg) ? -1 : 1;
        counter += Objects.isNull(contactEmail) ? -1 : 1;
        counter += Objects.isNull(clientSnils) ? -1 : 1;
        counter += Objects.isNull(clientInn) ? -1 : 1;
        counter += Objects.isNull(contactPhone) ? -1 : 1;
        counter += Objects.isNull(createDate) ? -1 : 1;
        counter += Objects.isNull(updateDate) ? -1 : 1;
        return counter > 0;
    }
}