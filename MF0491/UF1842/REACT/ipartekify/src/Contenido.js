import estilo from './Contenido.module.css';
import Galeria from './Galeria';

export default function Contenido() {
    return (
        <div class={estilo.contenido}>
            <Galeria />
            <Galeria />
            <Galeria />
            <Galeria />
            <Galeria />
        </div>);
}