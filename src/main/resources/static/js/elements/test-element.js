class TestElement extends HTMLElement {
  constructor(){
    super();
  }

  static get observedAttributes() {
    return ['test']
  }

  connectedCallback() {
    console.log("custom element added to page")
    this.attachShadow({mode: 'open'})
    this.shadowRoot.innerHTML = `
      <style>
        div {
          background-color: red;
        }
        ::slotted(span) {
          color: blue;
        }
      </style>

      <div>Name:
        <slot name="username"></slot>
      </div>
      <div>Birthday:
        <slot name="birthday"></slot>
      </div>
    `
  }

  disconnectedCallback() {
    console.log('custom element removed from page')
  }

  adoptedCallback() {
    console.log('custom element moved to new page')
  }

  attributeChangedCallback(name, oldValue, newValue) {
    console.log(`Attribute ${name} has changed, oldValue: ${oldValue} -> newValue: ${newValue}`);
  }
}

customElements.define('test-element', TestElement);