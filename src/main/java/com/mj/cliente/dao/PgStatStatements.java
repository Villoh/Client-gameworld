/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mj.cliente.dao;

import java.io.Serializable;
import java.math.BigInteger;

/**
 *
 * @author M3J2
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "pg_stat_statements", catalog = "qblzuhfb", schema = "public")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "PgStatStatements.findAll", query = "SELECT p FROM PgStatStatements p"),
    @javax.persistence.NamedQuery(name = "PgStatStatements.findByUserid", query = "SELECT p FROM PgStatStatements p WHERE p.userid = :userid"),
    @javax.persistence.NamedQuery(name = "PgStatStatements.findByDbid", query = "SELECT p FROM PgStatStatements p WHERE p.dbid = :dbid"),
    @javax.persistence.NamedQuery(name = "PgStatStatements.findByQueryid", query = "SELECT p FROM PgStatStatements p WHERE p.queryid = :queryid"),
    @javax.persistence.NamedQuery(name = "PgStatStatements.findByQuery", query = "SELECT p FROM PgStatStatements p WHERE p.query = :query"),
    @javax.persistence.NamedQuery(name = "PgStatStatements.findByCalls", query = "SELECT p FROM PgStatStatements p WHERE p.calls = :calls"),
    @javax.persistence.NamedQuery(name = "PgStatStatements.findByTotalTime", query = "SELECT p FROM PgStatStatements p WHERE p.totalTime = :totalTime"),
    @javax.persistence.NamedQuery(name = "PgStatStatements.findByMinTime", query = "SELECT p FROM PgStatStatements p WHERE p.minTime = :minTime"),
    @javax.persistence.NamedQuery(name = "PgStatStatements.findByMaxTime", query = "SELECT p FROM PgStatStatements p WHERE p.maxTime = :maxTime"),
    @javax.persistence.NamedQuery(name = "PgStatStatements.findByMeanTime", query = "SELECT p FROM PgStatStatements p WHERE p.meanTime = :meanTime"),
    @javax.persistence.NamedQuery(name = "PgStatStatements.findByStddevTime", query = "SELECT p FROM PgStatStatements p WHERE p.stddevTime = :stddevTime"),
    @javax.persistence.NamedQuery(name = "PgStatStatements.findByRows", query = "SELECT p FROM PgStatStatements p WHERE p.rows = :rows"),
    @javax.persistence.NamedQuery(name = "PgStatStatements.findBySharedBlksHit", query = "SELECT p FROM PgStatStatements p WHERE p.sharedBlksHit = :sharedBlksHit"),
    @javax.persistence.NamedQuery(name = "PgStatStatements.findBySharedBlksRead", query = "SELECT p FROM PgStatStatements p WHERE p.sharedBlksRead = :sharedBlksRead"),
    @javax.persistence.NamedQuery(name = "PgStatStatements.findBySharedBlksDirtied", query = "SELECT p FROM PgStatStatements p WHERE p.sharedBlksDirtied = :sharedBlksDirtied"),
    @javax.persistence.NamedQuery(name = "PgStatStatements.findBySharedBlksWritten", query = "SELECT p FROM PgStatStatements p WHERE p.sharedBlksWritten = :sharedBlksWritten"),
    @javax.persistence.NamedQuery(name = "PgStatStatements.findByLocalBlksHit", query = "SELECT p FROM PgStatStatements p WHERE p.localBlksHit = :localBlksHit"),
    @javax.persistence.NamedQuery(name = "PgStatStatements.findByLocalBlksRead", query = "SELECT p FROM PgStatStatements p WHERE p.localBlksRead = :localBlksRead"),
    @javax.persistence.NamedQuery(name = "PgStatStatements.findByLocalBlksDirtied", query = "SELECT p FROM PgStatStatements p WHERE p.localBlksDirtied = :localBlksDirtied"),
    @javax.persistence.NamedQuery(name = "PgStatStatements.findByLocalBlksWritten", query = "SELECT p FROM PgStatStatements p WHERE p.localBlksWritten = :localBlksWritten"),
    @javax.persistence.NamedQuery(name = "PgStatStatements.findByTempBlksRead", query = "SELECT p FROM PgStatStatements p WHERE p.tempBlksRead = :tempBlksRead"),
    @javax.persistence.NamedQuery(name = "PgStatStatements.findByTempBlksWritten", query = "SELECT p FROM PgStatStatements p WHERE p.tempBlksWritten = :tempBlksWritten"),
    @javax.persistence.NamedQuery(name = "PgStatStatements.findByBlkReadTime", query = "SELECT p FROM PgStatStatements p WHERE p.blkReadTime = :blkReadTime"),
    @javax.persistence.NamedQuery(name = "PgStatStatements.findByBlkWriteTime", query = "SELECT p FROM PgStatStatements p WHERE p.blkWriteTime = :blkWriteTime")})
public class PgStatStatements implements Serializable {

    private static final long serialVersionUID = 1L;
    @javax.persistence.Column(name = "userid")
    private BigInteger userid;
    @javax.persistence.Column(name = "dbid")
    private BigInteger dbid;
    @javax.persistence.Column(name = "queryid")
    private BigInteger queryid;
    @javax.persistence.Column(name = "query")
    private String query;
    @javax.persistence.Column(name = "calls")
    private BigInteger calls;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Column(name = "total_time")
    private Double totalTime;
    @javax.persistence.Column(name = "min_time")
    private Double minTime;
    @javax.persistence.Column(name = "max_time")
    private Double maxTime;
    @javax.persistence.Column(name = "mean_time")
    private Double meanTime;
    @javax.persistence.Column(name = "stddev_time")
    private Double stddevTime;
    @javax.persistence.Column(name = "rows")
    private BigInteger rows;
    @javax.persistence.Column(name = "shared_blks_hit")
    private BigInteger sharedBlksHit;
    @javax.persistence.Column(name = "shared_blks_read")
    private BigInteger sharedBlksRead;
    @javax.persistence.Column(name = "shared_blks_dirtied")
    private BigInteger sharedBlksDirtied;
    @javax.persistence.Column(name = "shared_blks_written")
    private BigInteger sharedBlksWritten;
    @javax.persistence.Column(name = "local_blks_hit")
    private BigInteger localBlksHit;
    @javax.persistence.Column(name = "local_blks_read")
    private BigInteger localBlksRead;
    @javax.persistence.Column(name = "local_blks_dirtied")
    private BigInteger localBlksDirtied;
    @javax.persistence.Column(name = "local_blks_written")
    private BigInteger localBlksWritten;
    @javax.persistence.Column(name = "temp_blks_read")
    private BigInteger tempBlksRead;
    @javax.persistence.Column(name = "temp_blks_written")
    private BigInteger tempBlksWritten;
    @javax.persistence.Column(name = "blk_read_time")
    private Double blkReadTime;
    @javax.persistence.Column(name = "blk_write_time")
    private Double blkWriteTime;

    public PgStatStatements() {
    }

    public BigInteger getUserid() {
        return userid;
    }

    public void setUserid(BigInteger userid) {
        this.userid = userid;
    }

    public BigInteger getDbid() {
        return dbid;
    }

    public void setDbid(BigInteger dbid) {
        this.dbid = dbid;
    }

    public BigInteger getQueryid() {
        return queryid;
    }

    public void setQueryid(BigInteger queryid) {
        this.queryid = queryid;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public BigInteger getCalls() {
        return calls;
    }

    public void setCalls(BigInteger calls) {
        this.calls = calls;
    }

    public Double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Double totalTime) {
        this.totalTime = totalTime;
    }

    public Double getMinTime() {
        return minTime;
    }

    public void setMinTime(Double minTime) {
        this.minTime = minTime;
    }

    public Double getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(Double maxTime) {
        this.maxTime = maxTime;
    }

    public Double getMeanTime() {
        return meanTime;
    }

    public void setMeanTime(Double meanTime) {
        this.meanTime = meanTime;
    }

    public Double getStddevTime() {
        return stddevTime;
    }

    public void setStddevTime(Double stddevTime) {
        this.stddevTime = stddevTime;
    }

    public BigInteger getRows() {
        return rows;
    }

    public void setRows(BigInteger rows) {
        this.rows = rows;
    }

    public BigInteger getSharedBlksHit() {
        return sharedBlksHit;
    }

    public void setSharedBlksHit(BigInteger sharedBlksHit) {
        this.sharedBlksHit = sharedBlksHit;
    }

    public BigInteger getSharedBlksRead() {
        return sharedBlksRead;
    }

    public void setSharedBlksRead(BigInteger sharedBlksRead) {
        this.sharedBlksRead = sharedBlksRead;
    }

    public BigInteger getSharedBlksDirtied() {
        return sharedBlksDirtied;
    }

    public void setSharedBlksDirtied(BigInteger sharedBlksDirtied) {
        this.sharedBlksDirtied = sharedBlksDirtied;
    }

    public BigInteger getSharedBlksWritten() {
        return sharedBlksWritten;
    }

    public void setSharedBlksWritten(BigInteger sharedBlksWritten) {
        this.sharedBlksWritten = sharedBlksWritten;
    }

    public BigInteger getLocalBlksHit() {
        return localBlksHit;
    }

    public void setLocalBlksHit(BigInteger localBlksHit) {
        this.localBlksHit = localBlksHit;
    }

    public BigInteger getLocalBlksRead() {
        return localBlksRead;
    }

    public void setLocalBlksRead(BigInteger localBlksRead) {
        this.localBlksRead = localBlksRead;
    }

    public BigInteger getLocalBlksDirtied() {
        return localBlksDirtied;
    }

    public void setLocalBlksDirtied(BigInteger localBlksDirtied) {
        this.localBlksDirtied = localBlksDirtied;
    }

    public BigInteger getLocalBlksWritten() {
        return localBlksWritten;
    }

    public void setLocalBlksWritten(BigInteger localBlksWritten) {
        this.localBlksWritten = localBlksWritten;
    }

    public BigInteger getTempBlksRead() {
        return tempBlksRead;
    }

    public void setTempBlksRead(BigInteger tempBlksRead) {
        this.tempBlksRead = tempBlksRead;
    }

    public BigInteger getTempBlksWritten() {
        return tempBlksWritten;
    }

    public void setTempBlksWritten(BigInteger tempBlksWritten) {
        this.tempBlksWritten = tempBlksWritten;
    }

    public Double getBlkReadTime() {
        return blkReadTime;
    }

    public void setBlkReadTime(Double blkReadTime) {
        this.blkReadTime = blkReadTime;
    }

    public Double getBlkWriteTime() {
        return blkWriteTime;
    }

    public void setBlkWriteTime(Double blkWriteTime) {
        this.blkWriteTime = blkWriteTime;
    }
    
}
