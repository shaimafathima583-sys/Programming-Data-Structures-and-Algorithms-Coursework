import React, { useState } from "react";
import { Compass, MapPin, ChevronRight, RotateCcw, TrendingUp,
    School, Hospital, Route, Landmark, ShoppingCart, UtensilsCrossed,
    Coffee, Pill, Wallet, Fuel } from "lucide-react";

import { MapContainer, TileLayer, Marker, Popup } from "react-leaflet";
import L from "leaflet";
import "./RecommendationResult.css";
import "leaflet/dist/leaflet.css";

// Color-coded marker icons per facility type (leaflet-color-markers CDN)
const iconUrl = (color) =>
    `https://raw.githubusercontent.com/pointhi/leaflet-color-markers/master/img/marker-icon-2x-${color}.png`;
const shadowUrl = "https://unpkg.com/leaflet@1.9.4/dist/images/marker-shadow.png";

const makeIcon = (color) => new L.Icon({
    iconUrl: iconUrl(color),
    shadowUrl,
    iconSize: [25, 41],
    iconAnchor: [12, 41],
    popupAnchor: [1, -34],
});

const typeIconMap = {
    school: makeIcon("blue"),
    hospital: makeIcon("red"),
    bank: makeIcon("gold"),
    supermarket: makeIcon("green"),
    restaurant: makeIcon("orange"),
    cafe: makeIcon("violet"),
    pharmacy: makeIcon("grey"),
    atm: makeIcon("black"),
    fuel: makeIcon("yellow"),
};

const getMarkerIcon = (type) => typeIconMap[type] ?? makeIcon("grey");

// Distinct marker for the recommended location itself
const recommendedIcon = new L.DivIcon({
    className: "recommended-marker",
    html: `<div class="recommended-marker-dot"></div>`,
    iconSize: [22, 22],
    iconAnchor: [11, 11],
});


function RecommendationResult({ recommendation, onBack }) {

    // Safety check
    if (!recommendation) {
        return (
            <div className="result-page">
                <h2>No recommendation available.</h2>
                <button className="new-search-button" onClick={onBack}>
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

    const [expandedType, setExpandedType] = useState(null);

    const facilityTypes = [
        { type: "school", label: "Schools", Icon: School },
        { type: "hospital", label: "Hospitals", Icon: Hospital },
        { type: "bank", label: "Banks", Icon: Landmark },
        { type: "supermarket", label: "Supermarkets", Icon: ShoppingCart },
        { type: "restaurant", label: "Restaurants", Icon: UtensilsCrossed },
        { type: "cafe", label: "Cafes", Icon: Coffee },
        { type: "pharmacy", label: "Pharmacies", Icon: Pill },
        { type: "atm", label: "ATMs", Icon: Wallet },
        { type: "fuel", label: "Fuel Stations", Icon: Fuel },
    ];

    const countByType = (type) => nearbyPlaces.filter(p => p.type === type).length;

    const activeFacility = facilityTypes.find(f => f.type === expandedType);
    const activeItems = expandedType ? nearbyPlaces.filter(p => p.type === expandedType) : [];

    const reasoning = [
        { stage: "Province", detail: `${recommendedProvince} selected — score ${provinceScore.toFixed(2)}, ${provinceDistance.toFixed(2)} km away` },
        { stage: "District", detail: `${selectedDistrict} selected — score ${districtScore.toFixed(2)}, ${districtDistance.toFixed(2)} km away` },
        { stage: "Location", detail: `${recommendedLocation} selected — score ${locationScore.toFixed(2)}, ${locationDistance.toFixed(2)} km away` },
        { stage: "OSM Enrichment", detail: `${nearbyPlaces.length} nearby places found (${countByType("school")} schools,${countByType("pharmacy")} pharmacies,
        ${countByType("cafe")} cafes, ${countByType("atm")} ATMs, ${countByType("fuel")} fuel stations, ${countByType("bank")} banks, ${countByType("supermarket")} supermarkets,
        ${countByType("restaurant")} restaurants, ${countByType("hospital")} hospitals)` },
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
                        <p className="result-eyebrow">MARKET EXPANSION</p>
                        <h1>Recommendation Results</h1>
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
                    <span>{currentBranch}</span>
                </div>

                <ChevronRight size={16} />

                <div className="path-item">
                    <span>{recommendedProvince}</span>
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
                    <div className="stage-number">01</div>
                    <div>
                        <p>PROVINCE ANALYSIS</p>
                        <h2>Recommended Province</h2>
                    </div>
                </div>

                <div className="province-card">

                    <div>
                        <span className="small-label">BEST EXPANSION OPPORTUNITY</span>
                        <h3>{recommendedProvince}</h3>
                        <div className="province-description">
                            <TrendingUp size={15} />
                            <span>
                                Recommended based on opportunity,
                                distance, and market potential.
                            </span>
                        </div>
                    </div>

                    <div className="province-score">
                        <span>Final Score</span>
                        <strong>{provinceScore.toFixed(2)}</strong>
                        <small>Opportunity</small>
                    </div>

                </div>

                <div className="analysis-details">

                    <div>
                        <span>Current Province</span>
                        <strong>{currentProvince}</strong>
                    </div>

                    <div>
                        <span>Distance from Current Location</span>
                        <strong>{provinceDistance.toFixed(2)} km</strong>
                    </div>

                </div>

            </section>



            {/* ================= DISTRICT ================= */}

            <section className="result-section">

                <div className="section-title">
                    <div className="stage-number">02</div>
                    <div>
                        <p>DISTRICT ANALYSIS</p>
                        <h2>Recommended District</h2>
                    </div>
                </div>

                <div className="district-grid">

                    <div className="district-card selected">

                        <div className="district-top">
                            <span className="rank">#1</span>
                            <span className="best-tag">BEST MATCH</span>
                        </div>

                        <h3>{selectedDistrict}</h3>

                        <div className="distance">
                            <Route size={13} />
                            <span>{districtDistance.toFixed(2)} km</span>
                            <span>from current branch</span>
                        </div>

                        <div className="district-score">
                            <span>Final Score</span>
                            <strong>{districtScore.toFixed(2)}</strong>
                        </div>

                    </div>

                </div>

            </section>



            {/* ================= LOCATION ================= */}

            <section className="result-section">

                <div className="section-title">
                    <div className="stage-number">03</div>
                    <div>
                        <p>LOCATION SELECTION</p>
                        <h2>Recommended Location</h2>
                    </div>
                </div>

                <div className="district-grid">

                    <div className="district-card selected">

                        <div className="district-top">
                            <span className="rank">#1</span>
                            <span className="best-tag">BEST MATCH</span>
                        </div>

                        <h3>{recommendedLocation}</h3>

                        <div className="distance">
                            <Route size={13} />
                            <span>{locationDistance.toFixed(2)} km</span>
                            <span>from current branch</span>
                        </div>

                        <div className="district-score">
                            <span>Final Score</span>
                            <strong>{locationScore.toFixed(2)}</strong>
                        </div>

                    </div>

                </div>

            </section>



            {/* ================= REASONING ================= */}

            <section className="result-section">

                <div className="section-title">
                    <div className="stage-number">04</div>
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
                    <div className="stage-number">05</div>
                    <div>
                        <p>LOCATION ANALYSIS</p>
                        <h2>Nearby Facilities</h2>
                    </div>
                </div>

                <div className="facility-grid">
                    {facilityTypes.map(({ type, label, Icon }) => {
                        const isOpen = expandedType === type;

                        return (
                            <div
                                key={type}
                                className={`facility-card ${isOpen ? "selected" : ""}`}
                                onClick={() => setExpandedType(isOpen ? null : type)}
                            >
                                <div className={`facility-icon ${type}`}>
                                    <Icon size={21} />
                                </div>
                                <div>
                                    <strong>{countByType(type)}</strong>
                                    <span>{label} nearby</span>
                                </div>
                            </div>
                        );
                    })}
                </div>

                {expandedType && (
                    <div className="facility-strip">

                        <div className="facility-strip-header">
                            <span>{activeFacility?.label}</span>
                            <button
                                className="facility-strip-close"
                                onClick={() => setExpandedType(null)}
                            >
                                Close
                            </button>
                        </div>

                        <div className="facility-strip-row">
                            {activeItems.length === 0 && (
                                <span className="facility-strip-empty">None found</span>
                            )}
                            {activeItems.map((p, i) => (
                                <div key={i} className="facility-chip">
                                    {p.name}
                                </div>
                            ))}
                        </div>

                    </div>
                )}

                <p className="facility-note">
                    Nearby facilities retrieved from
                    OpenStreetMap.
                </p>

            </section>



            {/* ================= MAP ================= */}

            <section className="result-section map-section">

                <div className="section-title">
                    <div className="stage-number">06</div>
                    <div>
                        <p>GEOGRAPHICAL VIEW</p>
                        <h2>Location Map</h2>
                    </div>
                </div>

                <div className="map-container">
                    <MapContainer
                        center={[recommendation.locationLatitude, recommendation.locationLongitude]}
                        zoom={14}
                        style={{ height: "400px", width: "800px", borderRadius: "8px" }}
                    >
                        <TileLayer
                            url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
                            attribution='&copy; OpenStreetMap contributors'
                        />

                        <Marker
                            position={[recommendation.locationLatitude, recommendation.locationLongitude]}
                            icon={recommendedIcon}
                        >
                            <Popup>{recommendedLocation} — Recommended</Popup>
                        </Marker>

                        {nearbyPlaces.map((p, i) => (
                            <Marker
                                key={i}
                                position={[p.latitude, p.longitude]}
                                icon={getMarkerIcon(p.type)}
                            >
                                <Popup>{p.name} ({p.type})</Popup>
                            </Marker>
                        ))}
                    </MapContainer>
                </div>

            </section>



            {/* ================= FOOTER ================= */}

            <div className="result-footer">
                <span>
                    Recommendation generated using
                    location data and opportunity scoring.
                </span>
                <span>BizScout</span>
            </div>

        </div>
    );
}

export default RecommendationResult;