import { useState } from "react";
import "./App.css";

import RecommendationInput from "./pages/RecommendationInput";
import RecommendationResult from "./pages/RecommendationResult";

function App() {

    const [page, setPage] = useState("input");

    const [recommendation, setRecommendation] =
        useState(null);


    // RECEIVE BACKEND RESPONSE
    
    const handleRecommendation = (data) => {

        console.log(
            "Recommendation received:",
            data
        );

        setRecommendation(data);

        setPage("result");
    };


    return (
        <>

            {/* INPUT PAGE */}

            {page === "input" && (

                <RecommendationInput
                    onNext={handleRecommendation}
                />

            )}


            {/* RESULT PAGE */}

            {page === "result" && (

                <RecommendationResult
                    recommendation={recommendation}
                    onBack={() => setPage("input")}
                />

            )}

        </>
    );
}

export default App;