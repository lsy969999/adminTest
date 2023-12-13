class TestButton extends HTMLElement {
  constructor(){
    super();
  }

  connectedCallback() {
    console.log("TestButton added to page")
    this.attachShadow({mode: 'open'})
    this.shadowRoot.innerHTML = `
      <button type="button" class="btn btn-primary">Base class</button>
    `
  }
}

customElements.define('test-button', TestButton);