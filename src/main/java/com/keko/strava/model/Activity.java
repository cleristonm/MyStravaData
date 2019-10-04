
package com.keko.strava.model;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "resource_state",
    "athlete",
    "name",
    "distance",
    "moving_time",
    "elapsed_time",
    "total_elevation_gain",
    "type",
    "workout_type",
    "id",
    "external_id",
    "upload_id",
    "start_date",
    "start_date_local",
    "timezone",
    "utc_offset",
    "start_latlng",
    "end_latlng",
    "location_city",
    "location_state",
    "location_country",
    "start_latitude",
    "start_longitude",
    "achievement_count",
    "kudos_count",
    "comment_count",
    "athlete_count",
    "photo_count",
    "map",
    "trainer",
    "commute",
    "manual",
    "private",
    "visibility",
    "flagged",
    "gear_id",
    "from_accepted_tag",
    "upload_id_str",
    "average_speed",
    "max_speed",
    "average_cadence",
    "average_watts",
    "kilojoules",
    "device_watts",
    "has_heartrate",
    "average_heartrate",
    "max_heartrate",
    "heartrate_opt_out",
    "display_hide_heartrate_option",
    "elev_high",
    "elev_low",
    "pr_count",
    "total_photo_count",
    "has_kudoed"
})
@Entity
public class Activity {
	@Id
    @JsonProperty("id")
    private Double id;
    @JsonProperty("resource_state")
    private Integer resourceState;
    @JsonProperty("athlete")
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="athlete", nullable=false)
    private Athlete athlete;
    @JsonProperty("name")
    private String name;
    @JsonProperty("distance")
    private Double distance;
    @JsonProperty("moving_time")
    private Integer movingTime;
    @JsonProperty("elapsed_time")
    private Integer elapsedTime;
    @JsonProperty("total_elevation_gain")
    private Double totalElevationGain;
    @JsonProperty("type")
    private String type;
    @JsonProperty("workout_type")
    private String workoutType;    
    @JsonProperty("external_id")
    private String externalId;
    @JsonProperty("upload_id")
    private Double uploadId;
    @JsonProperty("start_date")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss'Z'")
    private Timestamp startDate;
    @JsonProperty("start_date_local")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss'Z'")
    private Timestamp startDateLocal;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("utc_offset")
    private Double utcOffset;
    /*
    @JsonProperty("start_latlng")
    private List<Double> startLatlng = null;
    @JsonProperty("end_latlng")
    private List<Double> endLatlng = null;
    @JsonProperty("location_city")
    */
    private String locationCity;
    @JsonProperty("location_state")
    private String locationState;
    @JsonProperty("location_country")
    private String locationCountry;
    @JsonProperty("start_latitude")
    private Double startLatitude;
    @JsonProperty("start_longitude")
    private Double startLongitude;
    @JsonProperty("achievement_count")
    private Integer achievementCount;
    @JsonProperty("kudos_count")
    private Integer kudosCount;
    @JsonProperty("comment_count")
    private Integer commentCount;
    @JsonProperty("athlete_count")
    private Integer athleteCount;
    @JsonProperty("photo_count")
    private Integer photoCount;
    @JsonProperty("map")
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="map")
    private com.keko.strava.model.ActivityMap map;
    @JsonProperty("trainer")
    private Boolean trainer;
    @JsonProperty("commute")
    private Boolean commute;
    @JsonProperty("manual")
    private Boolean manual;
    @JsonProperty("private")
    private Boolean _private;
    @JsonProperty("visibility")
    private String visibility;
    @JsonProperty("flagged")
    private Boolean flagged;
    @JsonProperty("gear_id")
    private String gearId;
    @JsonProperty("from_accepted_tag")
    private Boolean fromAcceptedTag;
    @JsonProperty("upload_id_str")
    private String uploadIdStr;
    @JsonProperty("average_speed")
    private Double averageSpeed;
    @JsonProperty("max_speed")
    private Double maxSpeed;
    @JsonProperty("average_cadence")
    private Double averageCadence;
    @JsonProperty("average_watts")
    private Double averageWatts;
    @JsonProperty("kilojoules")
    private Double kilojoules;
    @JsonProperty("device_watts")
    private Boolean deviceWatts;
    @JsonProperty("has_heartrate")
    private Boolean hasHeartrate;
    @JsonProperty("average_heartrate")
    private Double averageHeartrate;
    @JsonProperty("max_heartrate")
    private Double maxHeartrate;
    @JsonProperty("heartrate_opt_out")
    private Boolean heartrateOptOut;
    @JsonProperty("display_hide_heartrate_option")
    private Boolean displayHideHeartrateOption;
    @JsonProperty("elev_high")
    private Double elevHigh;
    @JsonProperty("elev_low")
    private Double elevLow;
    @JsonProperty("pr_count")
    private Integer prCount;
    @JsonProperty("total_photo_count")
    private Integer totalPhotoCount;
    @JsonProperty("has_kudoed")
    private Boolean hasKudoed;
    

    @JsonProperty("resource_state")
    public Integer getResourceState() {
        return resourceState;
    }

    @JsonProperty("resource_state")
    public void setResourceState(Integer resourceState) {
        this.resourceState = resourceState;
    }

    @JsonProperty("athlete")
    public Athlete getAthlete() {
        return athlete;
    }

    @JsonProperty("athlete")
    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("distance")
    public Double getDistance() {
        return distance;
    }

    @JsonProperty("distance")
    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @JsonProperty("moving_time")
    public Integer getMovingTime() {
        return movingTime;
    }

    @JsonProperty("moving_time")
    public void setMovingTime(Integer movingTime) {
        this.movingTime = movingTime;
    }

    @JsonProperty("elapsed_time")
    public Integer getElapsedTime() {
        return elapsedTime;
    }

    @JsonProperty("elapsed_time")
    public void setElapsedTime(Integer elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    @JsonProperty("total_elevation_gain")
    public Double getTotalElevationGain() {
        return totalElevationGain;
    }

    @JsonProperty("total_elevation_gain")
    public void setTotalElevationGain(Double totalElevationGain) {
        this.totalElevationGain = totalElevationGain;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("workout_type")
    public String getWorkoutType() {
        return workoutType;
    }

    @JsonProperty("workout_type")
    public void setWorkoutType(String workoutType) {
        this.workoutType = workoutType;
    }

    @JsonProperty("id")
    public Double getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Double id) {
        this.id = id;
    }

    @JsonProperty("external_id")
    public String getExternalId() {
        return externalId;
    }

    @JsonProperty("external_id")
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    @JsonProperty("upload_id")
    public Double getUploadId() {
        return uploadId;
    }

    @JsonProperty("upload_id")
    public void setUploadId(Double uploadId) {
        this.uploadId = uploadId;
    }

    @JsonProperty("start_date")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss'Z'")     
    public Timestamp getStartDate() {
        return startDate;
    }

    @JsonProperty("start_date")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss'Z'")     
    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("start_date_local")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss'Z'")     
    public Timestamp getStartDateLocal() {
        return startDateLocal;
    }

    @JsonProperty("start_date_local")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss'Z'")  
    public void setStartDateLocal(Timestamp startDateLocal) {
        this.startDateLocal = startDateLocal;
    }

    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("utc_offset")
    public Double getUtcOffset() {
        return utcOffset;
    }

    @JsonProperty("utc_offset")
    public void setUtcOffset(Double utcOffset) {
        this.utcOffset = utcOffset;
    }

    /*
    @JsonProperty("start_latlng")
    public List<Double> getStartLatlng() {
        return startLatlng;
    }

    @JsonProperty("start_latlng")
    public void setStartLatlng(List<Double> startLatlng) {
        this.startLatlng = startLatlng;
    }

    @JsonProperty("end_latlng")
    public List<Double> getEndLatlng() {
        return endLatlng;
    }
    

    @JsonProperty("end_latlng")
    public void setEndLatlng(List<Double> endLatlng) {
        this.endLatlng = endLatlng;
    }
     */
    @JsonProperty("location_city")
    public String getLocationCity() {
        return locationCity;
    }

    @JsonProperty("location_city")
    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    @JsonProperty("location_state")
    public String getLocationState() {
        return locationState;
    }

    @JsonProperty("location_state")
    public void setLocationState(String locationState) {
        this.locationState = locationState;
    }

    @JsonProperty("location_country")
    public String getLocationCountry() {
        return locationCountry;
    }

    @JsonProperty("location_country")
    public void setLocationCountry(String locationCountry) {
        this.locationCountry = locationCountry;
    }

    @JsonProperty("start_latitude")
    public Double getStartLatitude() {
        return startLatitude;
    }

    @JsonProperty("start_latitude")
    public void setStartLatitude(Double startLatitude) {
        this.startLatitude = startLatitude;
    }

    @JsonProperty("start_longitude")
    public Double getStartLongitude() {
        return startLongitude;
    }

    @JsonProperty("start_longitude")
    public void setStartLongitude(Double startLongitude) {
        this.startLongitude = startLongitude;
    }

    @JsonProperty("achievement_count")
    public Integer getAchievementCount() {
        return achievementCount;
    }

    @JsonProperty("achievement_count")
    public void setAchievementCount(Integer achievementCount) {
        this.achievementCount = achievementCount;
    }

    @JsonProperty("kudos_count")
    public Integer getKudosCount() {
        return kudosCount;
    }

    @JsonProperty("kudos_count")
    public void setKudosCount(Integer kudosCount) {
        this.kudosCount = kudosCount;
    }

    @JsonProperty("comment_count")
    public Integer getCommentCount() {
        return commentCount;
    }

    @JsonProperty("comment_count")
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    @JsonProperty("athlete_count")
    public Integer getAthleteCount() {
        return athleteCount;
    }

    @JsonProperty("athlete_count")
    public void setAthleteCount(Integer athleteCount) {
        this.athleteCount = athleteCount;
    }

    @JsonProperty("photo_count")
    public Integer getPhotoCount() {
        return photoCount;
    }

    @JsonProperty("photo_count")
    public void setPhotoCount(Integer photoCount) {
        this.photoCount = photoCount;
    }

    @JsonProperty("map")
    public com.keko.strava.model.ActivityMap getMap() {
        return map;
    }

    @JsonProperty("map")
    public void setMap(com.keko.strava.model.ActivityMap map) {
        this.map = map;
    }

    @JsonProperty("trainer")
    public Boolean getTrainer() {
        return trainer;
    }

    @JsonProperty("trainer")
    public void setTrainer(Boolean trainer) {
        this.trainer = trainer;
    }

    @JsonProperty("commute")
    public Boolean getCommute() {
        return commute;
    }

    @JsonProperty("commute")
    public void setCommute(Boolean commute) {
        this.commute = commute;
    }

    @JsonProperty("manual")
    public Boolean getManual() {
        return manual;
    }

    @JsonProperty("manual")
    public void setManual(Boolean manual) {
        this.manual = manual;
    }

    @JsonProperty("private")
    public Boolean getPrivate() {
        return _private;
    }

    @JsonProperty("private")
    public void setPrivate(Boolean _private) {
        this._private = _private;
    }

    @JsonProperty("visibility")
    public String getVisibility() {
        return visibility;
    }

    @JsonProperty("visibility")
    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    @JsonProperty("flagged")
    public Boolean getFlagged() {
        return flagged;
    }

    @JsonProperty("flagged")
    public void setFlagged(Boolean flagged) {
        this.flagged = flagged;
    }

    @JsonProperty("gear_id")
    public String getGearId() {
        return gearId;
    }

    @JsonProperty("gear_id")
    public void setGearId(String gearId) {
        this.gearId = gearId;
    }

    @JsonProperty("from_accepted_tag")
    public Boolean getFromAcceptedTag() {
        return fromAcceptedTag;
    }

    @JsonProperty("from_accepted_tag")
    public void setFromAcceptedTag(Boolean fromAcceptedTag) {
        this.fromAcceptedTag = fromAcceptedTag;
    }

    @JsonProperty("upload_id_str")
    public String getUploadIdStr() {
        return uploadIdStr;
    }

    @JsonProperty("upload_id_str")
    public void setUploadIdStr(String uploadIdStr) {
        this.uploadIdStr = uploadIdStr;
    }

    @JsonProperty("average_speed")
    public Double getAverageSpeed() {
        return averageSpeed;
    }

    @JsonProperty("average_speed")
    public void setAverageSpeed(Double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    @JsonProperty("max_speed")
    public Double getMaxSpeed() {
        return maxSpeed;
    }

    @JsonProperty("max_speed")
    public void setMaxSpeed(Double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @JsonProperty("average_cadence")
    public Double getAverageCadence() {
        return averageCadence;
    }
    
    @JsonProperty("average_watts")
    public Double getAverageWatts() {
        return averageWatts;
    }

    @JsonProperty("average_cadence")
    public void setAverageCadence(Double averageCadence) {
        this.averageCadence = averageCadence;
    }

    @JsonProperty("has_heartrate")
    public Boolean getHasHeartrate() {
        return hasHeartrate;
    }

    @JsonProperty("has_heartrate")
    public void setHasHeartrate(Boolean hasHeartrate) {
        this.hasHeartrate = hasHeartrate;
    }

    @JsonProperty("average_heartrate")
    public Double getAverageHeartrate() {
        return averageHeartrate;
    }

    @JsonProperty("average_heartrate")
    public void setAverageHeartrate(Double averageHeartrate) {
        this.averageHeartrate = averageHeartrate;
    }

    @JsonProperty("max_heartrate")
    public Double getMaxHeartrate() {
        return maxHeartrate;
    }

    @JsonProperty("max_heartrate")
    public void setMaxHeartrate(Double maxHeartrate) {
        this.maxHeartrate = maxHeartrate;
    }

    @JsonProperty("heartrate_opt_out")
    public Boolean getHeartrateOptOut() {
        return heartrateOptOut;
    }

    @JsonProperty("heartrate_opt_out")
    public void setHeartrateOptOut(Boolean heartrateOptOut) {
        this.heartrateOptOut = heartrateOptOut;
    }

    @JsonProperty("display_hide_heartrate_option")
    public Boolean getDisplayHideHeartrateOption() {
        return displayHideHeartrateOption;
    }

    @JsonProperty("display_hide_heartrate_option")
    public void setDisplayHideHeartrateOption(Boolean displayHideHeartrateOption) {
        this.displayHideHeartrateOption = displayHideHeartrateOption;
    }

    @JsonProperty("elev_high")
    public Double getElevHigh() {
        return elevHigh;
    }

    @JsonProperty("elev_high")
    public void setElevHigh(Double elevHigh) {
        this.elevHigh = elevHigh;
    }

    @JsonProperty("elev_low")
    public Double getElevLow() {
        return elevLow;
    }

    @JsonProperty("elev_low")
    public void setElevLow(Double elevLow) {
        this.elevLow = elevLow;
    }

    @JsonProperty("pr_count")
    public Integer getPrCount() {
        return prCount;
    }

    @JsonProperty("pr_count")
    public void setPrCount(Integer prCount) {
        this.prCount = prCount;
    }

    @JsonProperty("total_photo_count")
    public Integer getTotalPhotoCount() {
        return totalPhotoCount;
    }

    @JsonProperty("total_photo_count")
    public void setTotalPhotoCount(Integer totalPhotoCount) {
        this.totalPhotoCount = totalPhotoCount;
    }

    @JsonProperty("has_kudoed")
    public Boolean getHasKudoed() {
        return hasKudoed;
    }

    @JsonProperty("has_kudoed")
    public void setHasKudoed(Boolean hasKudoed) {
        this.hasKudoed = hasKudoed;
    }

    

}
