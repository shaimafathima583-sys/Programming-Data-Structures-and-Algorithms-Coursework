import React from "react";

import {
    Compass,
    MapPin,
    ChevronRight,
    RotateCcw,
    TrendingUp,
    School,
    Hospital,
    Route,
} from "lucide-react";

import "./RecommendationResult.css";


function RecommendationResult({ recommendation, onBack }) {

    // Safety check
    if (!recommendation) {
        return (
            <div className="result-page">

                <h2>
                    No recommendation available.
                </h2>

                <button
                    className="new-search-button"
                    onClick={onBack}
                >
                    <RotateCcw size={15} />
                    Back
                </button>

            </div>
        );
    }

    // DATA FROM SPRING BOOT
    const currentBranch = recommendation.currentLocation;
    const currentProvince = recommendation.currentProvince;
    const recommendedProvince = recommendation.recommendedProvince;
    const provinceScore = recommendation.provinceScore;
    const provinceDistance = recommendation.provinceDistance;
    const selectedDistrict = recommendation.recommendedDistrict;
    const districtScore = recommendation.districtScore;
    const districtDistance = recommendation.districtDistance;
    const recommendedLocation = recommendation.recommendedLocation;
    const locationScore = recommendation.locationScore;
    const locationDistance = recommendation.locationDistance;
    const nearbyPlaces = recommendation.nearbyPlaces ?? [];
    const schoolCount = nearbyPlaces.filter(p => p.type === "school").length;
    const hospitalCount = nearbyPlaces.filter(p => p.type === "hospital").length;

    const reasoning = [
        { stage: "Province", detail: `${recommendedProvince} selected — score ${provinceScore.toFixed(2)}, ${provinceDistance.toFixed(2)} km away` },
        { stage: "District", detail: `${selectedDistrict} selected — score ${districtScore.toFixed(2)}, ${districtDistance.toFixed(2)} km away` },
        { stage: "Location", detail: `${recommendedLocation} selected — score ${locationScore.toFixed(2)}, ${locationDistance.toFixed(2)} km away` },
        { stage: "OSM Enrichment", detail: `${nearbyPlaces.length} nearby places found (${schoolCount} schools, ${hospitalCount} hospitals)` },
    ];


    return (
        <div className="result-page">


            {/* ================= HEADER ================= */}

            <header className="result-header">

                <div className="result-brand">

                    <div className="result-icon">
                        <Compass size={20} />
                    </div>

                    <div>

                        <p className="result-eyebrow">
                            MARKET EXPANSION
                        </p>

                        <h1>
                            Recommendation Results
                        </h1>

                        <p className="result-description">
                            Data-driven location analysis based on
                            your current branch and market opportunity.
                        </p>

                    </div>

                </div>


                <button
                    className="new-search-button"
                    onClick={onBack}
                >
                    <RotateCcw size={15} />
                    New Search
                </button>

            </header>



            {/* ================= PATH ================= */}

            <div className="location-path">
                <div className="path-item">
                    <MapPin size={15} />
                    <span>
                        {currentBranch}
                    </span>
                </div>
                <ChevronRight size={16} />


                <div className="path-item">
                    <span>
                        {recommendedProvince}
                    </span>
                </div>

                <ChevronRight size={16} />

                <div className="path-item">
                    <span>{selectedDistrict}</span>
                </div>

                <ChevronRight size={16} />


                <div className="path-item active">
                    <span>{recommendedLocation}</span>
                </div>

            </div>



            {/* ================= PROVINCE ================= */}

            <section className="result-section">

                <div className="section-title">

                    <div className="stage-number">
                        01
                    </div>

                    <div>

                        <p>
                            PROVINCE ANALYSIS
                        </p>

                        <h2>
                            Recommended Province
                        </h2>

                    </div>

                </div>



                <div className="province-card">

                    <div>

                        <span className="small-label">
                            BEST EXPANSION OPPORTUNITY
                        </span>


                        <h3>
                            {recommendedProvince}
                        </h3>


                        <div className="province-description">

                            <TrendingUp size={15} />

                            <span>
                                Recommended based on opportunity,
                                distance, and market potential.
                            </span>

                        </div>

                    </div>



                    <div className="province-score">

                        <span>
                            Final Score
                        </span>


                        <strong>
                            {provinceScore.toFixed(2)}
                        </strong>


                        <small>
                            Opportunity
                        </small>

                    </div>

                </div>


                {/* Province Details */}

                <div className="analysis-details">

                    <div>

                        <span>
                            Current Province
                        </span>

                        <strong>
                            {currentProvince}
                        </strong>

                    </div>


                    <div>

                        <span>
                            Distance from Current Location
                        </span>

                        <strong>
                            {provinceDistance.toFixed(2)} km
                        </strong>

                    </div>

                </div>

            </section>



            {/* ================= DISTRICT ================= */}

            <section className="result-section">

                <div className="section-title">

                    <div className="stage-number">
                        02
                    </div>

                    <div>

                        <p>
                            DISTRICT ANALYSIS
                        </p>

                        <h2>
                            Recommended District
                        </h2>

                    </div>

                </div>



                <div className="district-grid">

                    <div className="district-card selected">


                        <div className="district-top">

                            <span className="rank">
                                #1
                            </span>

                            <span className="best-tag">
                                BEST MATCH
                            </span>

                        </div>



                        <h3>
                            {selectedDistrict}
                        </h3>



                        <div className="distance">

                            <Route size={13} />

                            <span>
                                {districtDistance.toFixed(2)} km
                            </span>

                            <span>
                                from current branch
                            </span>

                        </div>



                        <div className="district-score">

                            <span>
                                Final Score
                            </span>

                            <strong>
                                {districtScore.toFixed(2)}
                            </strong>

                        </div>

                    </div>

                </div>

            </section>



            {/* ================= LOCATION ================= */}

            <section className="result-section">

                <div className="section-title">

                    <div className="stage-number">
                        03
                    </div>

                    <div>

                        <p>
                            LOCATION SELECTION
                        </p>

                        <h2>
                            Recommended Location
                        </h2>

                    </div>

                </div>



                <div className="district-grid">

                    <div className="district-card selected">

                        <div className="district-top">

                            <span className="rank">
                                #1
                            </span>

                            <span className="best-tag">
                                BEST MATCH
                            </span>

                        </div>


                        <h3>
                            {recommendedLocation}
                        </h3>


                        <div className="distance">

                            <Route size={13} />

                            <span>
                                {locationDistance.toFixed(2)} km
                            </span>

                            <span>
                                from current branch
                            </span>

                        </div>


                        <div className="district-score">

                            <span>
                                Final Score
                            </span>

                            <strong>
                                {locationScore.toFixed(2)}
                            </strong>

                        </div>

                    </div>

                </div>

            </section>



            {/* ================= REASONING ================= */}

            <section className="result-section">

                <div className="section-title">

                    <div className="stage-number">
                        04
                    </div>

                    <div>
                        <p>SELECTION LOGIC</p>
                        <h2>How we got here</h2>
                    </div>

                </div>

                <div className="reasoning-list">
                    {reasoning.map((step, i) => (
                        <div key={i} className="reasoning-item">
                            <span className="reasoning-stage">{step.stage}</span>
                            <span className="reasoning-detail">{step.detail}</span>
                        </div>
                    ))}
                </div>

            </section>



            {/* ================= FACILITIES ================= */}

            <section className="result-section">

                <div className="section-title">

                    <div className="stage-number">
                        05
                    </div>

                    <div>
                        <p>
                            LOCATION ANALYSIS
                        </p>
                        <h2>
                            Nearby Facilities
                        </h2>
                    </div>

                </div>



                <div className="facility-grid">

                    <div className="facility-card">

                        <div className="facility-icon school">

                            <School size={21} />

                        </div>


                        <div>

                            <strong>
                                {schoolCount}
                            </strong>

                            <span>
                                Schools nearby
                            </span>

                        </div>

                    </div>



                    <div className="facility-card">

                        <div className="facility-icon hospital">

                            <Hospital size={21} />

                        </div>


                        <div>

                            <strong>
                                {hospitalCount}
                            </strong>

                            <span>
                                Hospitals nearby
                            </span>

                        </div>

                    </div>

                </div>


                {nearbyPlaces.length > 0 && (
                    <ul className="place-list">
                        {nearbyPlaces.map((p, i) => (
                            <li key={i}>
                                {p.name} <span>({p.type})</span>
                            </li>
                        ))}
                    </ul>
                )}


                <p className="facility-note">

                    Nearby facilities retrieved from
                    OpenStreetMap through the Overpass API.

                </p>

            </section>



            {/* ================= MAP ================= */}

            <section className="result-section map-section">

                <div className="section-title">

                    <div className="stage-number">
                        06
                    </div>

                    <div>

                        <p>
                            GEOGRAPHICAL VIEW
                        </p>

                        <h2>
                            Location Map
                        </h2>

                    </div>

                </div>



                <div className="map-container">

                    <div className="map-content">

                        <div className="map-pin">

                            <MapPin size={26} />

                        </div>


                        <h3>
                            OpenStreetMap
                        </h3>


                        <p>

                            Recommended location:
                            <strong>
                                {" "}
                                {recommendedLocation}, {selectedDistrict}, {recommendedProvince}
                            </strong>

                        </p>


                        <button
                            className="view-map-button"
                        >

                            View Interactive Map

                            <ChevronRight size={15} />

                        </button>

                    </div>

                </div>

            </section>



            {/* ================= FOOTER ================= */}

            <div className="result-footer">

                <span>

                    Recommendation generated using
                    location data and opportunity scoring.

                </span>


                <span>
                    BizScout
                </span>

            </div>

        </div>
    );
}

export default RecommendationResult;