// https://docs.cypress.io/api/introduction/api.html

describe('DutchAuction Tests', () => {
  it('Visits the app root url', () => {
    cy.visit('http://localhost:8081')
    cy.contains('h1', 'Welcome to Dutch Auction')
  });

  it('Click on Create Auction, change page', () => {
    cy.get('#createAuction').click();
    cy.contains('.v-toolbar__title', 'Create Auction');
  });

  it('Click on Show Auctions, change page', () => {
    cy.get('#showAuction').click();
    cy.contains('.v-card__title', '10 kratten bananen');
  });

  it('Click on Name top left, change page', () => {
    cy.get('#titleName').click();
    cy.contains('h1', 'Welcome to Dutch Auction')
  });

  it('Click on Create Auction, create a new auction', () => {
    cy.get('#createAuction').click();
    cy.contains('.v-toolbar__title', 'Create Auction');
    cy.get('#auctionName').type('Dit is een test Auction.');
    cy.get('#auctionDescription').type("Dit is een test descriptie.");
    cy.get('.v-date-picker-table').click();
    cy.get('#validateButton').click();
    cy.contains('.v-snack', 'Success!');
  });

  it('Click on Show Auctions, check for just created auction', () => {
    cy.get('#showAuction').click();
    cy.contains('.v-card__title', 'Dit is een test Auction.');
  });
  
  it('Click on Create Auction, should not create a new auction, description is not filled', () => {
    cy.get('#createAuction').click();
    cy.contains('.v-toolbar__title', 'Create Auction');
    cy.get('#auctionName').type('Dit is een test Auction.');
    cy.get('.v-date-picker-table').click();
    cy.get('#validateButton').click();
    cy.contains('.v-messages__message', 'Description is required');
  });

  it('Click on Reset Form, should empty all input fields', () => {
    cy.get('#resetFormButton').click();
    cy.get('#auctionName').should('not.contain', 'Dit is een test Auction.');
  });

  it('Click on Create Auction, should not create a new auction, auction name is not filled', () => {
    cy.get('#createAuction').click();
    cy.contains('.v-toolbar__title', 'Create Auction');
    cy.get('#auctionDescription').type("Dit is een test descriptie.");
    cy.get('.v-date-picker-table').click();
    cy.get('#validateButton').click();
    cy.contains('.v-messages__message', 'Name is required');
  });

  it('Click on Reset Validation, all validation messages are gone', () => {
    cy.get('#resetValidationButton').click();
    cy.get('.v-messages__message').should('not.contain', 'Name is required');
  });
})
