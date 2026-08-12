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

const recommendations = [
    {
        rank: 1,
        name: "Colombo",
        score: 89.5,
        distance: 8.4,
    },
    {
        rank: 2,
        name: "Gampaha",
        score: 76.2,
        distance: 34.0,
    },
    {
        rank: 3,
        name: "Kalutara",
        score: 68.4,
        distance: 42.0,
    },
];

function RecommendationResult( { onBack } ) {
    const currentBranch = "Colombo Fort";
    const recommendedProvince = "Western";
    const selectedDistrict = "Colombo";

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

                <button className="new-search-button" onClick={onBack}>
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
                            BEST OPPORTUNITY
                        </span>

                        <h3>
                            {recommendedProvince}
                        </h3>

                        <div className="province-description">

                            <TrendingUp size={15} />

                            <span>
                                Highest opportunity score among
                                the analysed provinces.
                            </span>

                        </div>

                    </div>


                    <div className="province-score">

                        <span>
                            Opportunity Score
                        </span>

                        <strong>
                            89.50
                        </strong>

                        <small>
                            / 100
                        </small>

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
                            Recommended Districts
                        </h2>
                    </div>

                </div>


                <div className="district-grid">

                    {recommendations.map((district) => (

                        <div
                            key={district.name}
                            className={
                                district.rank === 1
                                    ? "district-card selected"
                                    : "district-card"
                            }
                        >

                            <div className="district-top">

                                <span className="rank">
                                    #{district.rank}
                                </span>

                                {district.rank === 1 && (
                                    <span className="best-tag">
                                        BEST MATCH
                                    </span>
                                )}

                            </div>


                            <h3>
                                {district.name}
                            </h3>


                            <div className="distance">

                                <Route size={13} />

                                <span>
                                    {district.distance} km
                                </span>

                                <span>
                                    from current branch
                                </span>

                            </div>


                            <div className="district-score">

                                <span>
                                    Opportunity Score
                                </span>

                                <strong>
                                    {district.score.toFixed(2)}
                                </strong>

                            </div>

                        </div>

                    ))}

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
                                14
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
                                6
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
                            Recommended locations and nearby
                            facilities will appear here.
                        </p>

                        <button className="view-map-button ">
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