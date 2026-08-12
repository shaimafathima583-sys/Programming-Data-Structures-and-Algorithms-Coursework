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

    const currentBranch =
        recommendation.currentLocation;

    const currentProvince =
        recommendation.currentProvince;

    const recommendedProvince =
        recommendation.recommendedProvince;

    const provinceScore =
        recommendation.provinceScore;

    const provinceDistance =
        recommendation.provinceDistance;

    const selectedDistrict =
        recommendation.recommendedDistrict;

    const districtScore =
        recommendation.districtScore;

    const districtDistance =
        recommendation.districtDistance;


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


                <div className="path-item active">

                    <span>
                        {selectedDistrict}
                    </span>

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



            {/* ================= FACILITIES ================= */}

            <section className="result-section">

                <div className="section-title">

                    <div className="stage-number">
                        03
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
                                —
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
                                —
                            </strong>

                            <span>
                                Hospitals nearby
                            </span>

                        </div>

                    </div>

                </div>



                <p className="facility-note">

                    Nearby facilities will be retrieved from
                    OpenStreetMap through the Overpass API.

                </p>

            </section>



            {/* ================= MAP ================= */}

            <section className="result-section map-section">

                <div className="section-title">

                    <div className="stage-number">
                        04
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
                                {selectedDistrict}, {recommendedProvince}
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