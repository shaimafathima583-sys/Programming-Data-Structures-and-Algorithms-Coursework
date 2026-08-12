import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import './App.css'
import RecommendationInput from "./pages/RecommendationInput";
import RecommendationResult from "./pages/RecommendationResult";

function App() {
    const [page, setPage] = useState("input");

    return (
        <>
            {page === "input" && (
                <RecommendationInput
                    onNext={() => setPage("result")}
                />
            )}

            {page === "result" && (
                <RecommendationResult
                    onBack={() => setPage("input")}
                />
            )}
        </>
    );
}


export default App
