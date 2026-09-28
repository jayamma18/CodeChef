const [prices, setPrices] = useState([])

useEffect(() => {
const fetchPrices = async () => {
const data = await fetchCryptoPrices()
setPrices(data)
}

fetchPrices()

const interval = setInterval(fetchPrices, 5000)

return () => clearInterval(interval)
}, [])

return (
<div style={{ fontFamily: 'sans-serif', padding: '20px' }}>
<h1>📈 Crypto Dashboard</h1>
<p>Updates every 5 seconds...</p>
<table style={{ borderCollapse: 'collapse', marginTop: '20px' }}>
<thead>
<tr>
<th style={{ padding: '8px', border: '1px solid gray' }}>Name</th>
<th style={{ padding: '8px', border: '1px solid gray' }}>Price ($)</th>
</tr>
</thead>
<tbody>
{prices.map((coin, index) => (
<tr key={index}>
<td style={{ padding: '8px', border: '1px solid gray' }}>{coin.name}</td>
<td style={{ padding: '8px', border: '1px solid gray' }}>{coin.price}</td>
</tr>
))}
</tbody>
</table>
</div>
)
}

export default App