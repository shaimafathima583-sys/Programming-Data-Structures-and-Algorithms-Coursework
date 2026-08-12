import { useState } from "react";
import "./RecommendationInput.css";
import locations from "../data/locations";

function RecommendationInput({ onNext }) {
    const [currentBranch, setCurrentBranch] = useState("");
    const [goal, setGoal] = useState("");
    const [businessType, setBusinessType] = useState("");

    const [loading, setLoading] = useState(false);
    const [error, setError] = useState("");

    const handleSubmit = async (e) => {
        e.preventDefault();

        setLoading(true);
        setError("");

        try {
            // Send current branch to Spring Boot backend
            const response = await fetch(
                `http://localhost:8080/api/recommendation?currentLocation=${encodeURIComponent(
                    currentBranch
                )}`
            );

            if (!response.ok) {
                throw new Error("Failed to get recommendation");
            }

            const data = await response.json();

            console.log("Recommendation Response:", data);

            /*
             * Send the backend result to App.jsx
             * so RecommendationResult can display it.
             */
            onNext({
                ...data,
                goal,
                businessType
            });

        } catch (error) {
            console.error("Recommendation error:", error);

            setError(
                "Unable to connect to the recommendation service. Please make sure the Spring Boot backend is running."
            );
        } finally {
            setLoading(false);
        }
    };

    return (
        <div className="recommendation-page">

            {/* Navigation */}
            <nav className="navbar">

                <div className="brand">

                    <div className="brand-icon">
                        B
                    </div>

                    <div>
                        <h2>BizScout</h2>

                        <span>
                            Business Location Intelligence
                        </span>
                    </div>

                </div>

                <div className="nav-right">

                    <span className="nav-link active">
                        Recommendation
                    </span>

                    <span className="nav-link">
                        About
                    </span>

                </div>

            </nav>


            {/* Main Content */}
            <main className="main-content">

                {/* Intro */}
                <section className="intro-section">

                    <span className="eyebrow">
                        LOCATION INTELLIGENCE
                    </span>

                    <h1>
                        Find the right location
                        <br />
                        <span>
                            for your next move.
                        </span>
                    </h1>

                    <p>
                        Use data-driven insights to identify promising
                        locations for your business expansion.
                    </p>

                </section>


                {/* Form Card */}
                <section className="form-card">

                    <div className="form-header">

                        <div>

                            <h2>
                                Start a Recommendation
                            </h2>

                            <p>
                                Tell us about your current business and
                                expansion goal.
                            </p>

                        </div>

                        <div className="step-indicator">

                            <span className="step-number">
                                01
                            </span>

                            <span>
                                INPUT
                            </span>

                        </div>

                    </div>


                    <form onSubmit={handleSubmit}>

                        {/* Current Branch */}
                        <div className="form-group">

                            <label htmlFor="currentBranch">
                                Current Branch
                            </label>

                            <p className="field-description">
                                Select the branch you are currently
                                operating from.
                            </p>

                            <select
                                id="currentBranch"
                                value={currentBranch}
                                onChange={(e) =>
                                    setCurrentBranch(e.target.value)
                                }
                                required
                            >

                                <option value="">
                                    Select your current branch
                                </option>

                                {locations.map((location) => (

                                    <option
                                        key={location.name}
                                        value={location.name}
                                    >
                                        {location.name} — {location.district}
                                    </option>

                                ))}

                            </select>

                        </div>


                        {/* Expansion Goal */}
                        <div className="form-group">

                            <label htmlFor="goal">
                                Expansion Goal
                            </label>

                            <p className="field-description">
                                What are you looking to achieve?
                            </p>

                            <select
                                id="goal"
                                value={goal}
                                onChange={(e) =>
                                    setGoal(e.target.value)
                                }
                                required
                            >

                                <option value="">
                                    Select your expansion goal
                                </option>

                                <option value="new-branch">
                                    Open a new branch
                                </option>

                                <option value="market-expansion">
                                    Expand into a new market
                                </option>

                                <option value="high-potential">
                                    Find a high-potential location
                                </option>

                            </select>

                        </div>


                        {/* Business Type */}
                        <div className="form-group">

                            <label htmlFor="businessType">
                                Business Type
                            </label>

                            <p className="field-description">
                                Select the category of your business.
                            </p>

                            <select
                                id="businessType"
                                value={businessType}
                                onChange={(e) =>
                                    setBusinessType(e.target.value)
                                }
                                required
                            >

                                <option value="">
                                    Select business type
                                </option>

                                <option value="retail">
                                    Retail
                                </option>

                                <option value="banking">
                                    Banking / Financial Services
                                </option>

                                <option value="food">
                                    Food & Beverage
                                </option>

                                <option value="healthcare">
                                    Healthcare
                                </option>

                                <option value="other">
                                    Other
                                </option>

                            </select>

                        </div>


                        {/* Province Information */}
                        <div className="info-box">

                            <div className="info-icon">
                                i
                            </div>

                            <div>

                                <strong>
                                    Automatic Province Detection
                                </strong>

                                <p>
                                    Your province will be automatically
                                    identified from the selected current
                                    branch using our location dataset.
                                </p>

                            </div>

                        </div>


                        {/* Error Message */}
                        {error && (
                            <div className="error-box">
                                {error}
                            </div>
                        )}


                        {/* Submit */}
                        <button
                            type="submit"
                            className="recommendation-button"
                            disabled={loading}
                        >

                            <span>
                                {loading
                                    ? "Analysing Location..."
                                    : "Find Recommendations"}
                            </span>

                            <span className="arrow">
                                {loading ? "..." : "→"}
                            </span>

                        </button>

                    </form>

                </section>


                {/* Footer Note */}
                <div className="bottom-note">

                    <span>
                        ●
                    </span>

                    Powered by data-driven location analysis

                </div>

            </main>

        </div>
    );
}

export default RecommendationInput;