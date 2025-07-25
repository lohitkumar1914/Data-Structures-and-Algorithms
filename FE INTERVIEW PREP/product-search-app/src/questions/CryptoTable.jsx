import React, { useState, useEffect } from "react";

const CryptoTable = () => {
  const [coins, setCoins] = useState([]);
  const [filteredCoins, setFilteredCoins] = useState([]);
  const [search, setSearch] = useState("");

  // Fetch data from CoinGecko
  const fetchCoins = async () => {
    try {
      const response = await fetch(
        "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd"
      );
      const data = await response.json();
      setCoins(data);
      setFilteredCoins(data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  // Initial fetch + refresh every 30s
  useEffect(() => {
    fetchCoins();
    const interval = setInterval(fetchCoins, 30000); // 30 seconds
    return () => clearInterval(interval); // cleanup on unmount
  }, []);

  // Filter coins by search input
  useEffect(() => {
    const results = coins.filter((coin) =>
      coin.name.toLowerCase().includes(search.toLowerCase())
    );
    setFilteredCoins(results);
  }, [search, coins]);

  return (
    <div style={{ padding: "20px", fontFamily: "Arial" }}>
      <h2>Crypto Prices</h2>
      <input
        type="text"
        placeholder="Search by coin name..."
        value={search}
        onChange={(e) => setSearch(e.target.value)}
        style={{ marginBottom: "10px", padding: "6px", width: "250px" }}
      />
      <table border="1" cellPadding="10" style={{ borderCollapse: "collapse" }}>
        <thead>
          <tr>
            <th>Name</th>
            <th>Symbol</th>
            <th>Current Price (USD)</th>
          </tr>
        </thead>
        <tbody>
          {filteredCoins.map((coin) => (
            <tr key={coin.id}>
              <td>{coin.name}</td>
              <td>{coin.symbol.toUpperCase()}</td>
              <td>${coin.current_price.toLocaleString()}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default CryptoTable;
