package model.to;

import java.sql.Date;

public class DriverInfo {

    private int driverid;
    private String drivername;
    private String licenceno;
    private Date expirydate;
    private String contactno;
    private String address;

    public int getDriverid() {
        return driverid;
    }

    public void setDriverid(int driverid) {
        this.driverid = driverid;
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public String getLicenceno() {
        return licenceno;
    }

    public void setLicenceno(String licenceno) {
        this.licenceno = licenceno;
    }

    public Date getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(Date expirydate) {
        this.expirydate = expirydate;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return driverid + " [ "  + drivername + " ] ";
    }
    
}
