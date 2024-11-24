<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>Create a New Gig | WorkPulse</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/gig/create.css">
</head>
<body>
<jsp:include page="../common/header.jsp" />

<div class="gig-create">
  <div class="container">
    <!-- Progress Navigation -->
    <div class="progress-nav">
      <div class="progress-steps">
        <div class="progress-step active" data-step="1">
          <div class="step-number">1</div>
          <span>Overview</span>
        </div>
        <div class="progress-step" data-step="2">
          <div class="step-number">2</div>
          <span>Pricing</span>
        </div>
        <div class="progress-step" data-step="3">
          <div class="step-number">3</div>
          <span>Description</span>
        </div>
        <div class="progress-step" data-step="4">
          <div class="step-number">4</div>
          <span>Gallery</span>
        </div>
        <div class="progress-step" data-step="5">
          <div class="step-number">5</div>
          <span>Publish</span>
        </div>
      </div>
      <div class="progress-bar">
        <div class="progress-fill" style="width: 20%"></div>
      </div>
    </div>

    <!-- Form Container -->
    <div class="form-container">
      <!-- Step 1: Overview -->
      <div class="form-step active" id="step1">
        <h2>Gig Overview</h2>
        <p class="step-description">Tell us about the service you're offering.</p>

        <form id="overviewForm" class="gig-form">
          <div class="form-group">
            <label for="gigTitle">Gig Title</label>
            <div class="input-wrapper">
              <input type="text" id="gigTitle" name="title"
                     placeholder="I will..." maxlength="80" required>
              <span class="char-count">0/80</span>
            </div>
            <p class="input-hint">Create a title that's clear and catchy.</p>
          </div>

          <div class="form-group">
            <label>Category</label>
            <div class="category-selects">
              <select name="category" id="category" required>
                <option value="">Select Category</option>
                <c:forEach items="${categories}" var="category">
                  <option value="${category.id}">${category.name}</option>
                </c:forEach>
              </select>

              <select name="subcategory" id="subcategory" required disabled>
                <option value="">Select Subcategory</option>
              </select>
            </div>
          </div>

          <div class="form-group">
            <label>Service Type</label>
            <div class="service-type-options">
              <label class="radio-option">
                <input type="radio" name="serviceType" value="oneTime" checked>
                <div class="radio-content">
                  <div class="radio-header">
                    <i class="fas fa-box"></i>
                    <span>One-time service</span>
                  </div>
                  <p>Deliver the service once per order</p>
                </div>
              </label>

              <label class="radio-option">
                <input type="radio" name="serviceType" value="ongoing">
                <div class="radio-content">
                  <div class="radio-header">
                    <i class="fas fa-sync"></i>
                    <span>Ongoing service</span>
                  </div>
                  <p>Provide continuous service with recurring bills</p>
                </div>
              </label>
            </div>
          </div>

          <div class="form-group">
            <label>Search Tags</label>
            <div class="tags-input-container">
              <div class="tags-list"></div>
              <input type="text" id="tagInput"
                     placeholder="Add up to 5 search tags..." maxlength="20">
            </div>
            <p class="input-hint">Help buyers find your service with relevant tags</p>
          </div>
        </form>
      </div>

      <!-- Step 2: Pricing -->
      <div class="form-step" id="step2">
        <h2>Pricing & Packages</h2>
        <p class="step-description">Set up your service packages and pricing.</p>

        <form id="pricingForm" class="gig-form">
          <div class="packages-container">
            <div class="package-tabs">
              <button type="button" class="package-tab active" data-package="basic">Basic</button>
              <button type="button" class="package-tab" data-package="standard">Standard</button>
              <button type="button" class="package-tab" data-package="premium">Premium</button>
            </div>

            <div class="package-content">
              <!-- Package Form -->
              <div class="form-group">
                <label>Package Title</label>
                <input type="text" name="packageTitle"
                       placeholder="Name your package" maxlength="40" required>
              </div>

              <div class="form-group">
                <label>Description</label>
                <textarea name="packageDescription"
                          placeholder="Describe what's included in this package"
                          rows="4" maxlength="100" required></textarea>
              </div>

              <div class="form-row">
                <div class="form-group">
                  <label>Delivery Time</label>
                  <select name="deliveryTime" required>
                    <option value="">Select delivery time</option>
                    <option value="1">1 day</option>
                    <option value="2">2 days</option>
                    <option value="3">3 days</option>
                    <option value="5">5 days</option>
                    <option value="7">7 days</option>
                    <option value="10">10 days</option>
                    <option value="14">14 days</option>
                    <option value="21">21 days</option>
                    <option value="30">30 days</option>
                  </select>
                </div>

                <div class="form-group">
                  <label>Number of Revisions</label>
                  <select name="revisions" required>
                    <option value="">Select revisions</option>
                    <option value="0">No revisions</option>
                    <option value="1">1 revision</option>
                    <option value="2">2 revisions</option>
                    <option value="3">3 revisions</option>
                    <option value="5">5 revisions</option>
                    <option value="unlimited">Unlimited</option>
                  </select>
                </div>
              </div>

              <div class="form-group">
                <label>Price</label>
                <div class="price-input">
                  <span class="currency">$</span>
                  <input type="number" name="price"
                         min="5" max="10000" step="5" required>
                </div>
              </div>

              <div class="form-group">
                <label>Features</label>
                <div class="features-list">
                  <div class="feature-input">
                    <input type="text" placeholder="Add a feature">
                    <button type="button" class="add-feature">
                      <i class="fas fa-plus"></i>
                    </button>
                  </div>
                  <div class="features-items"></div>
                </div>
              </div>
            </div>
          </div>
        </form>
      </div>

      <!-- Step 3: Description -->
      <div class="form-step" id="step3">
        <h2>Description & Details</h2>
        <p class="step-description">Provide a detailed description of your service.</p>

        <form id="descriptionForm" class="gig-form">
          <div class="form-group">
            <label>Gig Description</label>
            <textarea name="description" id="gigDescription"
                      rows="10" maxlength="1200" required
                      placeholder="Describe your service in detail..."></textarea>
            <div class="char-count">0/1200</div>
          </div>

          <div class="form-group">
            <label>Requirements</label>
            <p class="input-hint">What do you need from the buyer to get started?</p>
            <div class="requirements-list">
              <div class="requirement-input">
                <input type="text" placeholder="Add a requirement">
                <button type="button" class="add-requirement">
                  <i class="fas fa-plus"></i>
                </button>
              </div>
              <div class="requirements-items"></div>
            </div>
          </div>

          <div class="form-group">
            <label>FAQs</label>
            <div class="faqs-list">
              <button type="button" class="add-faq">
                <i class="fas fa-plus"></i>
                Add FAQ
              </button>
            </div>
          </div>
        </form>
      </div>

      <!-- Step 4: Gallery -->
      <div class="form-step" id="step4">
        <h2>Gallery</h2>
        <p class="step-description">Add photos and videos that best represent your service.</p>

        <form id="galleryForm" class="gig-form">
          <div class="gallery-container">
            <div class="upload-section">
              <h3>Images</h3>
              <p class="section-hint">Add up to 3 images that best showcase your service.</p>

              <div class="image-uploader">
                <div class="upload-box" id="imageUploader">
                  <i class="fas fa-cloud-upload-alt"></i>
                  <span>Drag & drop or browse</span>
                  <input type="file" multiple accept="image/*" hidden>
                </div>
                <div class="uploaded-images"></div>
              </div>
            </div>

            <div class="upload-section">
              <h3>Video (Optional)</h3>
              <p class="section-hint">Add a video that demonstrates your service.</p>

              <div class="video-uploader">
                <div class="upload-box" id="videoUploader">
                  <i class="fas fa-video"></i>
                  <span>Add a video</span>
                  <input type="file" accept="video/*" hidden>
                </div>
                <div class="uploaded-video"></div>
              </div>
            </div>
          </div>
        </form>
      </div>

      <!-- Step 5: Publish -->
      <div class="form-step" id="step5">
        <h2>Review & Publish</h2>
        <p class="step-description">Review your gig details before publishing.</p>

        <div class="review-container">
          <!-- Preview sections will be dynamically populated -->
          <div class="review-section" id="overviewPreview">
            <h3>Overview</h3>
            <div class="preview-content"></div>
          </div>

          <div class="review-section" id="pricingPreview">
            <h3>Pricing & Packages</h3>
            <div class="preview-content"></div>
          </div>

          <div class="review-section" id="descriptionPreview">
            <h3>Description & Details</h3>
            <div class="preview-content"></div>
          </div>

          <div class="review-section" id="galleryPreview">
            <h3>Gallery</h3>
            <div class="preview-content"></div>
          </div>
        </div>
      </div>

      <!-- Navigation Buttons -->
      <div class="form-navigation">
        <button type="button" class="btn-secondary back-btn" style="display: none;">
          <i class="fas fa-arrow-left"></i>
          Back
        </button>

        <button type="button" class="btn-primary next-btn">
          Continue
          <i class="fas fa-arrow-right"></i>
        </button>

        <button type="button" class="btn-primary publish-btn" style="display: none;">
          Publish Gig
          <i class="fas fa-check"></i>
        </button>
      </div>
    </div>
  </div>
</div>

<jsp:include page="../common/footer.jsp" />

<script src="${pageContext.request.contextPath}/js/gig/create.js"></script>
</body>
</html>
