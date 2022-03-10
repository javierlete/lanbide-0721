import './App.css';
import { FilterableProductTable } from './componentes/FilterableProductTable';
import { PRODUCTS } from './modelos/mock-products'

function App() {
  return (<FilterableProductTable products={PRODUCTS} />);
}

export default App;
