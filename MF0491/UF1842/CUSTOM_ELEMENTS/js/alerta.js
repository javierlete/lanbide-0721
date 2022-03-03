document.addEventListener('DOMContentLoaded', function () {
  class Alerta extends HTMLElement {
    constructor() {
      super();

      const texto = this.getAttribute('texto');
      const nivel = this.getAttribute('nivel');

      const div = document.createElement('div');

      div.className = 'alert alert-dismissible fade show alert-' + nivel;
      div.role = 'alert';
      div.innerHTML = texto + '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>';

      this.appendChild(div);
    }
  }

  // Define the new element
  customElements.define('jl-alerta', Alerta);
});
